//let 과 const 차이

// let 재할당이 가능
let a = 1;
a = 2;

//const 재할당이 불가능
//1. 상수
//2. 상수변수 또는 변수

const text = 'hello';
// text = 'hi'; //불가능(에러발생)

//1. 상수(상수는 항상 대문자)
const MAX_FRUITS = 5;

//2.재할당 불가능한 상수변수 또는 변수
const apple = {
  name: 'apple',
  color: 'red',
  display: '🍎',
};

//메모리에 할당된 const 값은 재할당이 불가능하지만
//메모리에 저장된 const 참조값의 내용은 변경할 수 있다!!

