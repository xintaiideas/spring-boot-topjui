$(function () {
    $(document).on("click","#openWinBtn",function () {
        $('#dd').iWindow('open');
    });
    $(document).on("click","#closeWinBtn",function () {
        $('#dd').iWindow('close');
    });
    //插入数据请求
    $(document).on("click","#insertBtn",function () {
        $.ajax({
            url:"/userinsert",
            data:$("#ff").serialize(),
            success:function (result) {
                alert("添加成功!");
                $('#dd').iWindow('close');
                $('#tt').iEdatagrid('reload');
            }
        })
    });
    //可编辑数据列表
    $('#tt').iEdatagrid({
        url: '/userdata',
        // saveUrl: '/usersave',
        updateUrl: '/userupdate',
        // destroyUrl: '/userdelete',

        toolbar: '#tb',
        autoSave:true,
        pageSize:10,
    });
    // 删除用户
    $(document).on("click","#deleteBtn",function () {
        var userCheckedId = $('.datagrid-cell-check input[name="uId"]:checked').val();
        if(0==userCheckedId.length) return;
        if(confirm("是否删除id:"+userCheckedId)){
            deleteUser(userCheckedId);
            $('#tt').iEdatagrid('reload');
        };
    });
    // 删除用户请求
    function deleteUser(userCheckedId) {
        $.ajax({
            url:"/userdelete",
            data:"uId="+userCheckedId,
            success:function (result) {
                alert("删除id:"+userCheckedId+"成功!");
            }
        })
    };
});