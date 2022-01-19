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
//                alert(data.retMsg);
                $("#commentForm").hide();
            } else {
                var isLogin = confirm(data.retMsg);

                if (data.retCode == "2023") {
                    if(isLogin == true) {
                        window.open("https://github.com/login/oauth/authorize?client_id=2bcd63e763491ab33831&redirect_uri=http://localhost:8887/callback&scope=user&state=0839");
                        window.localStorage.setItem("isClose", "true");
                    }
                }

            }
      },
      dataType: "json"
    });
}