var userList = {};
var currentUserId = -1;
function appendMessage(userId){
			var last = userList[currentUserId].length-1
			var content =  userList[currentUserId][last].chatContent
			var time = userList[currentUserId][last].chatTime
			//初始化聊天内容框
			var html = '<div class="message">';
			html += '<img src="img/2_copy.jpg" />';
			html += '<div class="bubble">';
			html += content;
			html += '<div class="corner"></div>';
			html += '<span></span>';
			html += '</div></div>';
			$('#chat-messages').append(html);
			$("#chat-messages").animate({scrollTop: "300px"},300);
				
			var sel = "user_"+data.userSendId;
			
			var friend = '<div class="friend" id="'+sel+'">';    
			friend+='<img src="img/2_copy.jpg" />';
			friend+='<p>';
			friend+='<strong>Martin Joseph</strong>';
			friend+='<label class="hidden">'+userId+'</label>';
			friend+='<span>marjoseph@gmail.com</span>';
			friend+='</p>';
			friend+='<div class="status away"></div>';
			friend+=' </div>';
			$("#friends").append(friend);			
	    	$("#chat-messages").animate({scrollTop: "300px"},300);
			
	    	
	    	
}


function getMessage(){  	
    	$.ajax({
    		url : "/jobcoming/message/ajax_getchat", 
			type : "post",
			dataType : "json",
			scriptCharset:"utf-8",
    		success:function(data){
    			
    			if(data.length>0){
    				$("#chatbox").fadeIn();
    				console.log(data)
    				for(var i=0;i<data.length;i++){
    					var message = data[i]
    					var userId =  message.userSendId
    					//将接收到的message存入map
    					if(userList[userId]!=null){
    						userList[userId].push({
    							chatContent:message.chatContent,
    							chatTime:message.chatTime
   							
    						})
    					}else{
    						var arr = [];
    						arr.push({
    							chatContent:message.chatContent,
    							chatTime:message.chatTime
    						})
    						userList[userId] = arr;
    					}
    					
    					appendMessage(userId);  					
    				}
    			}
    		},
    		error:function(data){
    			console.log("网络错误");
    		}
    	});
    	
   }
$(document).ready(function () {	
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
	    	currentUserId = $(this).find("label").html();	    	
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
    	//验证是否登陆
    	$.ajax({
    		url:"/jobcoming/ajax_isLogin",
    		dataType:"json",
    		success:function(data){
    			var userName = $("#jobPublisher").attr("data-userName");
    	    	var userId =  $("#jobPublisher").attr("data-userId");
    	    	var userEmail = $("#jobPublisher").attr("data-email");
    	    	var userImg = $("#user-avatar").attr("src");     	    	
    	    	userImg = userImg?userImg:"img/public.png";   
    	    	appendUser(userName,userImg,userEmail,userId);
    		},
    		error:function(data){
    			alert("请先登录！");
    		}
    		
    	});

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
    
	/**
	 * 发送消息
	 * @returns
	 */
    function sendMessage(){
    	
    	var chatContent = $("#content").val();
    	var receivedUserKey = currentUserId;
    	
    	sendHandle(chatContent);
    	$.ajax({
    		url : "/jobcoming/message/ajax_sendchat", 
			type : "post",
			dataType : "json",
    		data:{
    				"chatContent":chatContent,
    				"userRecieveId":receivedUserKey
    		},  	
    		success:function(data){
    			
    		},
    		error:function(data){
    			
    		}
    	});
    }
    
   
	
	
 
	    /**
	     * 在好友列表中加入用户
	     * @returns
	     */
	    function appendUser(userKey,userImage,userEmail="",userId){
	    	
	    	$("#chatbox").fadeIn();
	    	
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
