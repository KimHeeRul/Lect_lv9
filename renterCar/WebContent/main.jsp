<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet"  href="main.css" type="text/css">
</head>
<%
session.setAttribute("page", 0);
%>   
<body>
    <div class="wrap">
    <!--top-->
     	<jsp:include page="top.jsp" />
     	<!--top-->
        <main id="main">
        <aside id="aside"></aside>
            <section id="sec1">
                <article id="arti1" style=" border-bottom:1px solid gray;">
                   <span  style="margin:30px; font-weight: bold; font-size: 1.0em;">예약 하러 가기</span>
                        <p id=text style="margin: 20px">원하는 차량을 빠르게 예약하는 방법</p>

                    
                  <button id="button"  onclick="location.href='reservation.jsp'">예약하기</button>
                        

                </article>
                <article id="arti2" style=" border-bottom:1px solid gray ">
                <span  style="margin:30px; font-weight: bold; font-size: 1.0em;">이벤트</span>
               <p id=text style="margin: 20px">패밀리카 빠른출고 이벤트</p>
                 <button id="button" onclick="location.href='event.jsp'">이벤트 보러가기</button>
            </article>
                <article id="arti3" style=" border-bottom:1px solid gray">
                    <h3>프리미엄 차량관리서비스</h3>
                <p id=text>
                    ① 순회정비
                    - 계약 조건에 따른 월 단위 순회점검<br>
                    &nbsp;&nbsp;&nbsp;&nbsp;- 소모품 교환주기 시 협력업체 이용 가능<br>
                    ② 전국 400여개 협력 업체<br>
                    ③ 사고발생 시 대차서비스 제공<br>
                    ④ 24시간 콜 센터 운영<br>
                    ⑤ 24년 경력의 코스닥 상장사<br>
                    ⑥ 3개년 평균 재가입률 90%

                </p>
                </article>


            </section>

            <section id="sec2">
                <article id="arti4" style=" border-bottom:1px solid gray ;border-right:1px solid gray">
                <h3>장기 렌터카</h3>
                <p id=text>
                    편리하고 경제적으로 차량을 구매하는 방법
                    <img src="https://cdn.discordapp.com/attachments/870262837078016091/917347830966927370/unknown.png">
                </p>
                </article>
                <article id="arti5" style=" border-bottom:1px solid gray;border-right:1px solid gray">
                   <h3>특가 신차렌터카</h3>
                   <img src="https://media.discordapp.net/attachments/870262837078016091/917348590807056384/unknown.png">
                </article>
                <article id="arti6" style=" border-bottom:1px solid gray;border-right:1px solid gray">
                    <h3> BEST 인기차종</h3>
                    <img src="https://media.discordapp.net/attachments/870262837078016091/917348811754598400/unknown.png">

                </article>

            </section>
            <section id="sec3">
                <article id="arti7" style=" border-bottom:1px solid gray;" >
               <span  style="margin:30px; font-weight: bold; font-size: 1.5em;">빠른 상담과 정보</span>
                    <p id=text2 style="margin: 20px">무엇이든 질문하고 정보를 공유해요</p>

                    
                  <button id="button" onclick="location.href='community.jsp'" style="font-size: 1.5em; margin: 20px">커뮤니티 바로가기</button>
                        
                </article>
                <article id="arti8" style=" border-bottom:1px solid gray">
                    
                <h3>
                    공지사항
                </h3>
                <p id=text2>．개인정보처리방침 변경 안내</p>
                <p id=text2>．차량 옵션용품 구입 및 설치 입찰공고</p>
                
                </article>
                <article id="arti9" style=" border-bottom:1px solid gray">
                <h3>
                    대표번호
                </h3>
                <h1>
                    1544 ．0000
                </h1>
                
                </article>
                <article id="arti10" style=" border-bottom:1px solid gray">
                <h3>
                    지점안내
                </h3>
                <p id=text2>
                    전국 21개 지점과 100여개 제휴공업사에서<br>
                사고수리 및 차량정비 서비스 제공
                </p>
                </article>
                <article id="arti11" style=" border-bottom:1px solid gray">
                    <h3>
                카매니저
                    </h3>        
                     <p id=text2>
                        고객의 계약정보확인, 차량관리, 비용처리를<br>
                        효율적으로 쉽게 할 수 있는 차량관리 솔루션
                    </p>
                </article>

            </section>
      	<aside id=aside2></aside>
        </main>
          	 <!--bottom-->
     	<jsp:include page="bottom.jsp" />
     	<!--bottom-->
      

    </div>
</body>
</html>