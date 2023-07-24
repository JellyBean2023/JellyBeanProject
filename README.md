# JellyBean BackEnd
## 목표
천재교육 디지털러닝팀의 KDT 교육 소개 및 신청 웹 사이트 구축을 목표로 한다.
## 기간
2023.06.15 ~ 2023.08.10
## 멤버구성
고현욱 팀장, 프론트, 서버

김동현 프론트, DB, 서버

김소현 PM

유다희 백엔드

임하늘 백엔드

손진경 개발자문

## 개발환경
Java SE : Oracle JDK-11

Framework : Springboot 2.7.13

IDE : Intellij

Database : Maria DB 11.0.2

Server : Ubuntu 22.04 LTS

## 주요 기능
### KDT 강의 소개 및 강의 신청
+ KDT 강의 소개
관리자가 입력한 KDT 소개를 DB에 저장한다.
DB에 저장된 값들을 통해, 홈페이지에서 사용자는 과정별로 KDT 강의의 소개를 조회할 수 있고, 경우에 따라 모든 과정을 조회할 수도 있다.
+ KDT 강의 신청
사용자가 KTD 강의 신청폼에서 입력한 값들을 DB에 저장한다.
이후, DB에서 각 사용자에 따른 신청 내역을 확인할 수 있다.
### 이미지 업로드 및 다운로드
+ 하나 혹은 다수의 이미지 업로드 및 다운로드 가능
+ 이미지는 로컬 서버에 저장되고, DB에는 이미지의 저장 경로만 저장
+ 업로드 시 파일명 자동 생성(ex. banner_image_001)
### 이메일 인증 코드 발송 및 확인
+ 이메일 인증 코드 발송
회원가입 시, 스프링부트에서 제공하는 JavaMailSender를 이용하여 회원이 입력한 이메일로 인증코드를 발송한다.
이때, 회원의 이메일과 발송한 인증번호를 DB에 저장한다.
+ 인증코드 확인
회원이 이메일로 받은 인증코드를 입력 후, 인증코드 확인 버튼을 누르면, DB에 저장된 인증코드 값과 입력한 인증코드 값이 같은지 비교하여 true/false를 반환한다.
### 회원가입 및 로그인, 로그아웃
+ Spring security, JWT를 활용하여 구현
+ 회원가입 시 비밀번호 암호화하여 DB저장
+ 로그인 시 JWT 토큰 전달 및 웹 페이지에서 유효시간내 사용 가능
+ 로그아웃 시 JWT토큰을 redis를 통해 blacklist화 시켜 삭제
+ jwt provider에 토큰 검증 및 exception처리 추가
