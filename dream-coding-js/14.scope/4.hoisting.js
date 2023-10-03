// 함수의 호이스팅은 함수의 선언문 전에 호출이 가능하게 함
// 함수의 선언문은 선언 이전에도 호출이 가능함

print();

function print() {
  console.log('Hello');
};

// 변수(let, const)와 클래스는 선언만 호이스팅이 되고,
// 초기화는 안됨 (값 할당이 안됨)
// 초기화 전, 변수에 접근하면 컴파일(빌드)에러가 발생한다
console.log(hi);
let hi = 'hi';
// error - Cannot access 'hi' before initialization

const cat = new Cat();
class Cat {}

let x = 1;
{
  console.log(x);
  let x = 2;
};
// 스코프 안에서는 현재 변수 선언만 된 상태라서 error가 뜬다!


