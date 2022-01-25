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
//            window.location.reload();
            $('#comment-' + e).toggle();
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
                textarea.setAttribute("placeholder", "回复一下...");
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
    $('#comment-' + e.getAttribute("id")).toggle();
}

function showSelectTag() {
    $("#select-tag").show();
}

function selectTag(e) {
  var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();

    if (previous) {
        var index = 0;
        var appear = false; //记录value是否已经作为一个独立的标签出现过
        while (true) {
            index = previous.indexOf(value, index); //value字符串在previous中出现的位置
            if (index == -1) break;
            //判断previous中出现的value是否是另一个标签的一部分
            //即value的前一个和后一个字符都是逗号","或者没有字符时，才说明value是一个独立的标签
            if ((index == 0 || previous.charAt(index - 1) == ",")
                && (index + value.length == previous.length || previous.charAt(index + value.length) == ",")
               ) {
                appear = true;
                break;
            }
            index++; //用于搜索下一个出现位置
        }
        if (!appear) {
            //若value没有作为一个独立的标签出现过
            $("#tag").val(previous + ',' + value);
        }
    }
    else {
        $("#tag").val(value);
    }

//更新通知为已读标志
function updateReadNum(e) {
    var value = e.getAttribute("id");
    debugger;
    var value = e.getAttribute("id");
}

}