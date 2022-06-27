# Tetris

Java Swing으로 구현한 테트리스입니다.  

- 객체지향적 설계와 프로그래밍을 연습하기 위한 토이프로젝트입니다.
- SRP를 지키기 위해 클래스를 세분화했으며, 클래스 간 의존관계를 단순화하기 위헤 노력했습니다
- 멀티 스레드와 소켓을 활용하여 1:1 대결까지 구현할 예정입니다. 현재는 1인용만 가능합니다.

## Build & Run
```shell
javac --release 8 -d ./Tetris/out/ -cp ./Tetris/src/main/ ./Tetris/src/main/TetrisApp.java
java -cp ./Tetris/out TetrisApp
```
## 실행 화면
<img width="1212" alt="스크린샷 2022-06-22 오전 2 27 31" src="https://user-images.githubusercontent.com/16686954/174861135-f07cbf27-eb9c-4ff2-b15c-c4e9b05b7ba1.png">
