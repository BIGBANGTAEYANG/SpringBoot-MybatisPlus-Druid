var table;
$(document).ready(function(){

    datetimeInit();

    dataTableInit();

});

//循环取form表单数据
function getFormData(formid) {
    var data = {};
    //获取TEXT文件内容
    $("#" + formid + " input[type=text]").each(function(i, o) {
        var jo = $(o);
        if (jo.attr("name")) {
            var str = jo.val();
            str = str.replace(" ", "");
            if (str !== "") {
                data[jo.attr("name")] = jo.val();
            }
        }
    });
    data["productSize"]=$("#productSize").val();
    return data;
}


function stockSave(){
    $.ajax({
       url:'/sys/product-in-info/productInAdd',
       type:'POST',
       data:JSON.stringify(getFormData("stockForm")),
       dataType:"JSON",
       contentType:"application/json;charset=utf-8",
       success:function(res){
           if(res.returnCode==200){
               table.ajax.reload(null,false); //刷新table且分页不重置
           }else{
               alert(res.returnMsg);
           }
       }
    });
}

function datetimeInit(){
    //时间控件
    $('#inDate').datetimepicker({
        useCurrent:true,
        icons: {
            time: 'fa fa-clock',
            date: 'fa fa-calendar',
            up: 'fa fa-arrow-up',
            down: 'fa fa-arrow-down',
            previous: 'fa fa-chevron-left',
            next: 'fa fa-chevron-right',
            today: 'fa fa-calendar-check-o',
            clear: 'fa fa-delete',
            close: 'fa fa-times'
        },
        format:true
    });
}

function dataTableInit(){
    table = $('#dataTable').DataTable({
        paging:true,
        destroy:true,
        lengthChange:true,
        processing: true,
        searching: true,
        ordering:true,
        serverSide: true,//true代表后台处理分页，false代表前台处理分页
        aaSorting : [[0, "asc"]], //默认的排序方式，第1列，升序排列
        scrollX:true, //水平新增滚动轴
        aLengthMenu:[5,10,15,20],
        autoWidth:false,
        bJQueryUI:true,
        ajax: {
            "type":"POST",
            "url": "/sys/product-in-info/getProductPage",
            //"data": queryData,
            "dataSrc":function(res){
                return res.data;
            }
        },
        columns: [
            { "data": "inId", "title": "ID", "name": "inId", "visible": true},
            { "data": "productId", "title": "条码", "name": "productId", "visible": true},
            { "data": "productNo", "title": "商品编码", "name": "productNo", "visible": true},
            { "data": "productName", "title": "商品名称", "name": "productName", "visible": true},
            { "data": "providerName", "title": "发货商", "name": "providerName", "visible": false},
            { "data": "productColor", "title": "颜色", "name": "productColor", "visible": true},
            { "data": "productSize", "title": "尺码", "name": "productSize", "visible": true},
            { "data": "productNum", "title": "商品数量", "name": "productNum", "visible": false},
            { "data": "productPrice", "title": "进价", "name": "productPrice", "visible": true},
            { "data": "productSetPrice", "title": "定价", "name": "productSetPrice", "visible": true},
            { "data": "expressNo", "title": "快递单号", "name": "expressNo", "visible": true},
            { "data": "inDate", "title": "入库时间", "name": "inDate", "visible": true}
        ],
        oLanguage: {    // 语言设置
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "抱歉， 没有找到",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "sZeroRecords": "没有检索到数据",
            "sSearch": "检索:",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "前一页",
                "sNext": "后一页",
                "sLast": "尾页"
            }
        }
    });
}