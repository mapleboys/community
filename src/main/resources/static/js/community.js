function commentPost(){
    var parent_id = $("#parent_id").val();
    var type = 0;
    var content = $("#comment_content").val()
    var datas = {"parentId":parent_id,"type":type, "content":content}
    $.ajax({
      type: "POST",
      url: "/comment",
      contentType : "application/json",
      data: JSON.stringify(datas),
      success: function(data){
            if(data.retCode == "200") {
                alert(data.retMsg);
            } else {
                $( "#commentForm").hide();
            }
      },
      dataType: "json"
    });
}