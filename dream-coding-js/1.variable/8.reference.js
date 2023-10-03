//값과 참조의 차이

//원시타입은 값이 복사되어 전달됨
let a = 1;
let b = a; //  b=1 (b에 a의 값이 들어간다)
b =2; //a=1 b=2
console.log(a);

//객체타입은 참조값(메모리주소, 레퍼런스)가 복사되어 전달됨
let apple = {
  name: '사과',
};
let orange = apple; //orange에는 apple의 참조값이 저장됨
orange.name = '오렌지'; //참조값을 타고 들어가 Heap 데이터 자체를 변경함 
console.log(apple); //오렌지
console.log(orange); //오렌지
