var table;
$(document).ready(function(){

    datetimeInit();

    dataTableInit();

});


function stockSave(){
    $.ajax({
       url:'/sys/product-in-info/productInAdd',
       type:'POST',
       data:$("#stockForm").serialize(),
       dataType:"JSON",
       success:function(data){
          console.log(data);
       }
    });
}

function datetimeInit(){
    //时间控件
    $('#inStackDate').datetimepicker({
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
        }
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
            "url": "/sys/stack-info/getStackPage",
            //"data": queryData,
            "dataSrc":function(res){
                return res.data;    //自定义数据源，默认为data
            }
        },
        columns: [
            { "data": "productId", "title": "条码", "name": "userId", "visible": true},
            { "data": "productNo", "title": "商品编码", "name": "userName", "visible": true},
            { "data": "productName", "title": "商品名称", "name": "passWord", "visible": true},
            { "data": "providerName", "title": "发货商", "name": "userId", "visible": false},
            { "data": "productColor", "title": "颜色", "name": "userName", "visible": true},
            { "data": "productSize", "title": "尺码", "name": "passWord", "visible": true},
            { "data": "productNum", "title": "商品数量", "name": "userId", "visible": false},
            { "data": "productPrice", "title": "进价", "name": "userName", "visible": true},
            { "data": "productSetPrice", "title": "定价", "name": "passWord", "visible": true},
            { "data": "inStackDate", "title": "入库时间", "name": "passWord", "visible": true},
            { "data": "updateStackDate", "title": "库存更新时间", "name": "passWord", "visible": true}
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