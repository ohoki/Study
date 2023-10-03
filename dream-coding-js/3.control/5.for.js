//반복문 Loop Statement
// for(변수선언문; 조건식; 증감식) {}
//실행순서:
//1. 변수선언문
//2. 조건식의 값이 참이면 {} 코드블럭을 수행
//3. 증감식을 수행
//4. 조건식이 거짓이 될때까지 2번과 3번을 반복함

for(let i = 0; i < 5; i++) {   //증감식 자리에 i+2같은 다른 식도 가능!
  console.log(i);
}

//2중 for문

for(let i = 0; i < 5; i++) {
  for(let j = 0; j < 5; j++) {
    console.log(i, j);
  }
}

//무한루프 조심하기
// for(;;) {
//   console.log('ㅎㅎ');
// }

for(let i = 0; i < 20; i++) {
  console.log(i);
  if (i === 10) {
    continue;
    console.log('i가 드디어 10이 되었다!!');
    break;
  }
}
//continue의 경우 아래 문을 전부 무시하고 바로 반복문으로 올려버림
//break는 반복을 끊어버림

