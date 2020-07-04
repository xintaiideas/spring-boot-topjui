function doSearch(){
    $('#menuTg-toolbar').datagrid('load',{
        name: $('#queryNameText').val(),
        age: $('#queryAgeText').val()
    });
}