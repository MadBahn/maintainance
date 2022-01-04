function del(id,url) {
    console.log(id);
    if(confirm("此操作不可逆转，是否继续删除"+id+"？")){
        window.location.href = url+id;
    }
}