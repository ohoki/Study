// 콜백함수 (내가 나중에 호출해줄게~~)
//일급함수 - 함수가 일반 객체처럼 모든 연산이 가능한 것
//고차함수 - 인자로 함수를 받거나(콜백함수), 함수를 return하는 함수

const add = (a,b) => a + b;
const multiply = (a,b) => a * b;

//전달된 action은 콜백함수이다.
//전달될 당시에 함수를 바로 호출해서 반환된 값을 전달하는 것이 아니라
//함수를 가리키고 있는 함수의 레퍼런스(참조값)가 전달된다.
//그래서 함수는 고차함수(calculator)안에서 필요한 순간에 나중에 호출 됨
function calculator(a, b, action) {
  let result = action(a, b);
  console.log(result);
  return result;
}

calculator(1, 2, add); 
calculator(1, 2, multiply);
//함수를 직접적으로 호출하는게 아니라 add에 들어있는 함수의 참조값을 전달
