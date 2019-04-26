var table;
$(document).ready(function(){
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
        language: {"url":"json/datatables_language.json"},
        aLengthMenu:[5,10,15,20],
        autoWidth:false,
        bJQueryUI:true,
        ajax: {
            "type":"POST",
            "url": "/sys/user-info/getUserPage",
            //"data": queryData,
            "dataSrc":function(res){
                //dataSrc相当于success，在datatable里面不能用success方法，会覆盖datatable内部回调方法
                if(res.returnCode!=200){
                    alert(data.returnMsg);
                }
                return res.data;    //自定义数据源，默认为data
            }
        },
        "columns": [
            { "data": "userId", "title": "ID", "name": "userId", "visible": false},
            { "data": "userName", "title": "姓名", "name": "userName", "visible": true},
            { "data": "passWord", "title": "密码", "name": "passWord", "visible": true}
        ]
    });
});