function appendMessage(data){
	
			
			var html = '<div class="message">';
			html += '<img src="img/2_copy.jpg" />';
			html += '<div class="bubble">';
			html += data.chatContent;
			html += '<div class="corner"></div>';
			html += '<span>3s</span>';
			html += '</div></div>';
			$('#chat-messages').append(html);	    	
			$("#chat-messages").animate({scrollTop: "300px"},300);
				
			var sel = "user_"+data.userSendId;
			
				var friend = '<div class="friend" id="'+sel+'">';
				friend+='<img src="img/2_copy.jpg" />';
				friend+='<p>';
				friend+='<strong>Martin Joseph</strong>';
				friend+='<span>marjoseph@gmail.com</span>';
				friend+='</p>';
				friend+='<div class="status away"></div>';
				friend+=' </div>';
				$("#friends").append(friend);	
			
					
	    	$("#chat-messages").animate({scrollTop: "300px"},300);
			
	    	
	    	
}
		
		

function getMessage(){  	
    	$.ajax({
    		url : "ChatServlet", 
			type : "post",
			dataType : "json",
			scriptCharset:"utf-8",
    		data:{"action":"get"},
    		success:function(data){
    			
    			if(data.length>0){
    				$("#chatbox").fadeIn();
    				for(var i=0;i<data.length;i++){
    					appendMessage(data[i]);  					
    				}
    			}
    		},
    		error:function(data){
    			console.log("链接错误");
    		}
    	});
    	
   }
$(document).ready(function () {	
		var cp = "-1";
	    var preloadbg = document.createElement('img');
	    preloadbg.src = 'img/timeline1.png';
	    $('#searchfield').focus(function () {
	        if ($(this).val() == 'Search contacts...') {
	            $(this).val('');
	        }
	    });
	    $('#searchfield').focusout(function () {
	        if ($(this).val() == '') {
	            $(this).val('Search contacts...');
	        }
	    });
	    $('#sendmessage input').focus(function () {
	        if ($(this).val() == 'Send message...') {
	            $(this).val('');
	        }
	    });
	    $('#sendmessage input').focusout(function () {
	        if ($(this).val() == '') {
	            $(this).val('Send message...');
	        }
	    });
	    $("#friends").on("click",".friend",function(){	    	
	    	cp = $(this).find("label").html();	    	
            var childOffset = $(this).offset();
            var parentOffset = $(this).parent().parent().offset();
            var childTop = childOffset.top - parentOffset.top;
            var clone = $(this).find('img').eq(0).clone();
            var top = childTop + 12 + 'px';
            $(clone).css({ 'top': top }).addClass('floatingImg').appendTo('#chatbox');
            setTimeout(function () {
                $('#profile p').addClass('animate');
                $('#profile').addClass('animate');
            }, 100);
            setTimeout(function () {
                $('#chat-messages').addClass('animate');
                $('.cx, .cy').addClass('s1');
                setTimeout(function () {
                    $('.cx, .cy').addClass('s2');
                }, 100);
                setTimeout(function () {
                    $('.cx, .cy').addClass('s3');
                }, 200);
            }, 150);
            $('.floatingImg').animate({
                'width': '68px',
                'left': '108px',
                'top': '20px'
            }, 200);
            var name = $(this).find('p strong').html();
            var email = $(this).find('p span').html();
            $('#profile p').html(name);
            $('#profile span').html(email);
            $('.message').not('.right').find('img').attr('src', $(clone).attr('src'));
            $('#friendslist').fadeOut();
            $('#chatview').fadeIn();
            $('#close').unbind('click').click(function () {
                $('#chat-messages, #profile, #profile p').removeClass('animate');
                $('.cx, .cy').removeClass('s1 s2 s3');
                $('.floatingImg').animate({
                    'width': '40px',
                    'top': top,
                    'left': '12px'
                }, 200, function () {
                    $('.floatingImg').remove();
                });
                setTimeout(function () {
                    $('#chatview').fadeOut();
                    $('#friendslist').fadeIn();
                }, 50);
            });
	    });
	 
    /*点击私聊，来初始化聊天框*/
    $("#private-chat").click(function(){
    	var user = $("#jobPublisher").attr("data-person");
    	var userId =  $("#jobPublisher").attr("data-Id");
    	var userEmail = $("#jobPublisher").attr("data-email");
    	var userImg = $("#user-avatar").attr("src");   	
    	appendUser(user,userImg,"",userId);
    });
    $("#chat-close").click(function(){
    	
    	$("#chatbox").fadeOut();
    });
  
  //将发送的消息添加到消息框里
	function sendHandle(content){

    	
    	var html = '<div class="message right">';
    		html += '<img src="img/2_copy.jpg" />';
    		html += '<div class="bubble">';
    		html += content;
    		html += '<div class="corner"></div>';
    		html += '<span>3 min</span>';
    		html += '</div></div>';
    	$('#chat-messages').append(html);	    	
    	$("#chat-messages").animate({scrollTop: "300px"},300);
    	$("#content").val("");
	}
    
    function sendMessage(){
    	
    	var content = $("#content").val();
    	var receivedUserKey = cp;
    	sendHandle(content);
    	$.ajax({
    		url : "ChatServlet", 
			type : "post",
			dataType : "json",
    		data:{
    				"action":"send",
    				"content":content,
    				"receivedUserKey":receivedUserKey
    		},  	
    		success:function(data){
    			//发送成功
    		},
    		error:function(data){
    			console.log(data);
    		}
    	});
    }
    
   
	
	
 
	    /**
	     * 在好友列表中加入用户
	     * @returns
	     */
	    function appendUser(userKey,userImage,userEmail="",userId){
	    	
	    	$("#chatbox").fadeIn();
	    	console.log($("#"+userKey+""));
	    	$("#friends").html("");	
			var friend = '<div class="friend">';
			friend+='<img src="'+userImage+'" />';
			friend+='<p>';
			friend+='<strong>'+userKey+'</strong>';
			friend+='<label class="hidden">'+userId+'</label>';
			friend+='<span>'+userEmail+'</span>';
			friend+='</p>';
			friend+='<div class="status away"></div>';
			friend+=' </div>';
			$("#friends").append(friend);
			
	    }
	    $("#send").click(function(){
	    	sendMessage();
	    });
	    
	   window.setInterval("getMessage()",2000);
	   
	});
