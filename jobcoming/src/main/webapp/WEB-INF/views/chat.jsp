<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/chat.css" />
		<link rel="stylesheet" href="css/reset.css" />
	</head>

	<body>
			<div class="header">
				<span class="btns">
				<i class="icon-base close"></i>
			</span>
			</div>
			<div class="content chat" style="display: block;">
				<div class="scroll-wrapper mCustomScrollbar _mCS_1">
					<div id="mCSB_1" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" style="max-height: none;" tabindex="0">
						<div id="mCSB_1_container" class="mCSB_container" style="position: relative; top: 0px; left: 0px;" dir="ltr">
							<ul class="chat-list">
								<li class="chat-item system"> —— &nbsp;连接成功&nbsp; —— </li>
								<li class="chat-item left">
									<h3 class="title">小&nbsp;J</h3>
									<p class="lg">尊敬的用户您好，请问有什么可以帮助您的！</p>
								</li>
								
							</ul>
						</div>					
						
					</div>
				</div>
				<div class="toolbox">
					<i class="icon-base emoji" id="emojiBtn">
					<style type="text/css">
					.emoji-face{ 
						width: 25px;
						height: 25px; 
						background-repeat: no-repeat; 
						display: inline-block; 
						cursor: pointer; 
						background-image: url(img/emoji.png);
						}
					</style>
					<ul>
						<li title="smile">
							<span class="emoji-face" onclick="window.getEmojiCode(':smile:')" title="smile" style="background-position: 0px 0px;"></span>
						</li>
						<li title="smiley">
							<span class="emoji-face" onclick="window.getEmojiCode(':smiley:')" title="smiley" style="background-position: -25px 0px;"></span>
						</li>
						<li title="laughing">
							<span class="emoji-face" onclick="window.getEmojiCode(':laughing:')" title="laughing" style="background-position: -50px 0px;"></span>	
						</li>
						<li title="blush">
							<span class="emoji-face" onclick="window.getEmojiCode(':blush:')" title="blush" style="background-position: -75px 0px;"></span>
						</li>
						<li title="heart_eyes">
							<span class="emoji-face" onclick="window.getEmojiCode(':heart_eyes:')" title="heart_eyes" style="background-position: 0px -25px;"></span>
						</li>
						<li title="smirk">
							<span class="emoji-face" onclick="window.getEmojiCode(':smirk:')" title="smirk" style="background-position: -25px -25px;"></span>
						</li>
						<li title="flushed">
							<span class="emoji-face" onclick="window.getEmojiCode(':flushed:')" title="flushed" style="background-position: -50px -25px;"></span>
						</li>
						<li title="kissing_heart">
							<span class="emoji-face" onclick="window.getEmojiCode(':kissing_heart:')" title="kissing_heart" style="background-position: -75px -25px;"></span>
						</li>
						<li title="grin">
							<span class="emoji-face" onclick="window.getEmojiCode(':grin:')" title="grin" style="background-position: 0px -50px;"></span>
						</li>
						<li title="wink">
							<span class="emoji-face" onclick="window.getEmojiCode(':wink:')" title="wink" style="background-position: -25px -50px;"></span>
						</li>
						<li title="stuck_out_tongue_winking_eye">
							<span class="emoji-face" onclick="window.getEmojiCode(':stuck_out_tongue_winking_eye:')" title="stuck_out_tongue_winking_eye" style="background-position: -50px -50px;"></span>
						</li>
						<li title="stuck_out_tongue_closed eyes">
							<span class="emoji-face" onclick="window.getEmojiCode(':stuck_out_tongue_closed eyes:')" title="stuck_out_tongue_closed eyes" style="background-position: -75px -50px;"></span>
						</li>
						<li title="sleeping">
							<span class="emoji-face" onclick="window.getEmojiCode(':sleeping:')" title="sleeping" style="background-position: 0px -75px;"></span>
						</li>
						<li title="worried">
							<span class="emoji-face" onclick="window.getEmojiCode(':worried:')" title="worried" style="background-position: -25px -75px;"></span>
						</li>
						<li title="expressionless">
							<span class="emoji-face" onclick="window.getEmojiCode(':expressionless:')" title="expressionless" style="background-position: -50px -75px;"></span>
						</li>
						<li title="sweat_smile">
							<span class="emoji-face" onclick="window.getEmojiCode(':sweat_smile:')" title="sweat_smile" style="background-position: -75px -75px;"></span>
						</li>
						<li title="joy">
							<span class="emoji-face" onclick="window.getEmojiCode(':joy:')" title="joy" style="background-position: 0px -100px;"></span>
						</li>
						<li title="cold_sweat">
							<span class="emoji-face" onclick="window.getEmojiCode(':cold_sweat:')" title="cold_sweat" style="background-position: -25px -100px;"></span>
						</li>
						<li title="sob">
							<span class="emoji-face" onclick="window.getEmojiCode(':sob:')" title="sob" style="background-position: -50px -100px;"></span>
						</li>
						<li title="angry">
							<span class="emoji-face" onclick="window.getEmojiCode(':angry:')" title="angry" style="background-position: -75px -100px;"></span>
						</li>
						<li title="mask">
							<span class="emoji-face" onclick="window.getEmojiCode(':mask:')" title="mask" style="background-position: 0px -125px;"></span>
						</li>
						<li title="scream">
							<span class="emoji-face" onclick="window.getEmojiCode(':scream:')" title="scream" style="background-position: -25px -125px;"></span>
						</li>
						<li title="sunglasses">
							<span class="emoji-face" onclick="window.getEmojiCode(':sunglasses:')" title="sunglasses" style="background-position: -50px -125px;"></span>
						</li>
						<li title="heart">
							<span class="emoji-face" onclick="window.getEmojiCode(':heart:')" title="heart" style="background-position: -75px -125px;"></span>
						</li>
						<li title="broken_heart">
							<span class="emoji-face" onclick="window.getEmojiCode(':broken_heart:')" title="broken_heart" style="background-position: 0px -150px;"></span>
						</li>
						<li title="star">
							<span class="emoji-face" onclick="window.getEmojiCode(':star:')" title="star" style="background-position: -25px -150px;"></span>
						</li>
						<li title="anger">
							<span class="emoji-face" onclick="window.getEmojiCode(':anger:')" title="anger" style="background-position: -50px -150px;"></span>
						</li>
						<li title="exclamation">
								<span class="emoji-face" onclick="window.getEmojiCode(':exclamation:')" title="exclamation" style="background-position: -75px -150px;"></span>
						</li>
						<li title="question">
							<span class="emoji-face" onclick="window.getEmojiCode(':question:')" title="question" style="background-position: 0px -175px;"></span>
						</li>
						<li title="zzz">
							<span class="emoji-face" onclick="window.getEmojiCode(':zzz:')" title="zzz" style="background-position: -25px -175px;"></span>
						</li>
						<li title="thumbsup">
							<span class="emoji-face" onclick="window.getEmojiCode(':thumbsup:')" title="thumbsup" style="background-position: -50px -175px;"></span>
						</li>
						<li title="thumbsdown">
							<span class="emoji-face" onclick="window.getEmojiCode(':thumbsdown:')" title="thumbsdown" style="background-position: -75px -175px;"></span>
						</li>
						<li title="ok_hand">
							<span class="emoji-face" onclick="window.getEmojiCode(':ok_hand:')" title="ok_hand" style="background-position: 0px -200px;"></span>
						</li>
						<li title="punch">
							<span class="emoji-face" onclick="window.getEmojiCode(':punch:')" title="punch" style="background-position: -25px -200px;"></span>
						</li>
						<li title="yeah">
							<span class="emoji-face" onclick="window.getEmojiCode(':yeah:')" title="yeah" style="background-position: -50px -200px;"></span>
						</li>
						<li title="clap">
							<span class="emoji-face" onclick="window.getEmojiCode(':clap:')" title="clap" style="background-position: -75px -200px;"></span>
						</li>
						<li title="muscle">
							<span class="emoji-face" onclick="window.getEmojiCode(':muscle:')" title="muscle" style="background-position: 0px -225px;"></span>
						</li>
						<li title="pray">
							<span class="emoji-face" onclick="window.getEmojiCode(':pray:')" title="pray" style="background-position: -25px -225px;"></span>
						</li>
						<li title="skull">
							<span class="emoji-face" onclick="window.getEmojiCode(':skull:')" title="skull" style="background-position: -50px -225px;"></span>
						</li>
						<li title="trollface">
							<span class="emoji-face" onclick="window.getEmojiCode(':trollface:')" title="trollface" style="background-position: -75px -225px;"></span>
						</li>
					</ul>
				</i> 
				</div>
				<textarea id="chatText" name="chatText" class="chat-text" placeholder="您好，你有什么问题需要反馈"></textarea>
				<div class="submit">快捷键: Enter
					<input type="button" name="submit" class="submit-msg" value="发送" id="send">
				</div>
			</div>			
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/zUI.js" ></script>
		<script>
		$(function(){
			$("#mCSB_1").panel({iWheelStep:32});
		});
			
			$(".close").click(function(){
				var a = $('#webchat7moor', window.parent.document).css("display","none");
			})
			$("#emojiBtn").click(function(){
				var emo_isblock = $(this).find("ul").css("display");
				if(emo_isblock=="none"){
					$("#emojiBtn").find("ul").css("top","-137px")
					.css("display","block");
				}
				else{
					$("#emojiBtn").find("ul").css("top","0px")
					.css("display","none");
				}
			});
			function getEmojiCode(con){
				var value = $("#chatText").val();
				$("#chatText").val(value+con);
			}
			$("#send").click(function(){
				var value = $("#chatText").val();
				if(value!=""){
					$(".chat-list").append("<li class='chat-item right'><h3 class='title'>某用户</h3><p class='lg'>"+value+"</p></li>")
					$("#chatText").val("");
					var h_ul = $(".chat-list").height();
					var h = 278-h_ul+"px";
					$("#mCSB_1_container").css("top",h);
				}
				
			})
		</script> 
	</body>

</html>