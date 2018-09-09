메이븐 사용시 gRPC 설정법 (with spring-boot)

pom.xml의 버전 참고 : https://github.com/grpc/grpc-java

generate-sources 할 때
gson header 못찾는다고 뜨면 .m2 디렉토리 삭제 후 다시 진행

Protocol Buffers editor plug-in for eclipse : protobuf-dt
(but it keeps occurring error everytime I excute 'generate sources' and change '.proto' file)

===================================================
- Protocol Buffers(.proto 파일)로부터 java class 생성하기
프로젝트 우클릭 -> Run as -> 7 Maven generate-sources
target/generated-sources/protobuf 하위에 grpc-java, java 디렉토리 생성 확인

- 기존 생성한 Protocol Buffers java class 지우기
프로젝트 우클릭 -> Run as -> 6 Maven clean