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
                window.location.reload();
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
// 二级评论
function subCommentPost(e){
    var parent_id = e;
//    var parent_id = $("#comment.id").val();
    var type = 1;
    var tt = '#subComment_content-' + parent_id;
    var content = $('#subComment_content-' + parent_id).val();
    var datas = {"parentId":parent_id,"type":type, "content":content}

    $.ajax({
      type: "POST",
      url: "/comment",
      contentType : "application/json",
      data: JSON.stringify(datas),
      success: function(data){

        if(data.retCode == "200") {
//                $("#commentForm").hide();
            window.location.reload();
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
//展开二级评论
function collapseComments(e){
var id = 'comment-' + e.getAttribute("id");
var commentDiv =document.getElementById(id);

$.ajax({
      type: "GET",
      url: "/comment/" + e.getAttribute("id"),
      contentType : "application/json",
      data: null,
      success: function(data){

            if(data.retCode == "200") {
                commentDiv.innerHTML = ""

                for (var i = 0; i < data.data.length; i++) {
                    var comment = data.data[i];
                    var subCommentDiv = document.createElement("div");
                    var avatarDiv = document.createElement("div");
                    // 头像
                    var dt = document.createElement("dt");
                    dt.className = "pull-left";
                    var a = document.createElement("a");
                    var img = document.createElement("img");
                    img.setAttribute("class", "media-object img-thumbnail");
                    img.setAttribute("src", comment.user.avatarUrl);
                    img.setAttribute("style", "width:40px;height:40px");
                    a.appendChild(img);
                    dt.appendChild(a);
                    avatarDiv.appendChild(dt);
                    subCommentDiv.appendChild(avatarDiv);
                    // 姓名
                    var dd = document.createElement("dd");
                    dd.setAttribute("class", "pull-left");
                    var span = document.createElement("span");
                    span.setAttribute("class", "media-heading");
                    span.innerHTML = comment.user.name;
                    span.setAttribute("style", "margin:25px");
                    dd.appendChild(span);
                    var hr = document.createElement("hr");
                    avatarDiv.appendChild(dd);

                    avatarDiv.setAttribute("style", "height:40px;margin:10px;")
                    subCommentDiv.appendChild(avatarDiv);
                    //二级评论内容
                    var contentDiv = document.createElement("div");
                    var span1 = document.createElement("span");
                    span1.innerHTML = comment.content;
                    span1.setAttribute("style", "margin-left:75px;padding-bottom:15px;");
                    contentDiv.appendChild(span1);
                    subCommentDiv.appendChild(contentDiv);
                    subCommentDiv.appendChild(hr);
                    commentDiv.appendChild(subCommentDiv);
//                    commentDiv.insertBefore(subCommentDiv);
                }
                var input = document.createElement("div");
                var textarea = document.createElement("textarea");
                textarea.setAttribute("class", "form-control");
                textarea.rows="2";
                textarea.setAttribute("id", 'subComment_content-' + e.getAttribute("id"));
                input.appendChild(textarea);

                var button = document.createElement("button");
                button.setAttribute("type", "button");
                button.setAttribute("class", "btn btn-success commentBut");
                button.setAttribute("onclick", "subCommentPost(" + e.getAttribute("id") + ")");
                button.innerHTML="提交";
                input.appendChild(button);
                input.setAttribute("style", "height:110px;");


                commentDiv.appendChild(input);
//                if (data.data.length != 0) {
//                    $('#comment-' + e.getAttribute("id")).toggle();
//                }
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

    // 输入框
//    var input = document.createElement("div");
////    var textarea = document.createElement("textarea");
////    textarea.setAttribute("class", "form-control");
////    textarea.rows="2";
////    textarea.setAttribute("id", 'subComment_content-' + id);
////    input.appendChild(textarea);
//      input.innerHTML = '<textarea maxlength="5000" cols="80" rows="40"></textarea>' +
//                            '<button></button>';
//    debugger;
////    var button = document.createElement("button");
////    button.setAttribute("type", "button");
////    button.setAttribute("class", "btn btn-success commentBut");
////    button.setAttribute("onclick", "subCommentPost()");
////    input.appendChild(button);
////    debugger;
//    commentDiv.appendChild(input);
    $('#comment-' + e.getAttribute("id")).toggle();
}