//function name () {}  ==>함수 선언문 
//const name = function () {}  ==>함수 표현식
//화살표 함수 const name = () => {}

let add = function(a, b) {
  return a + b;
}; //이름이 없는 함수: 무명함수 (값으로 지정한 함수의 경우)
//함수도 객체이기 때문에 값으로 할당 가능함!
console.log(add(1, 2));

//Arrow function
add = (a, b) => {
  return a + b;
};
console.log(add(1, 2));

//특별한 일을 하지 않고 값만 리턴하는 함수의 경우 불필요한 요소들을 생략할 수 있다
add = (a, b) => a + b;
console.log(add(1, 2));

//IIFE (Immedicately-Inovoked Function Expressions)
//즉각적으로 호출되는 함수 표현식
(function run() {
  console.log('ㅎㅎ');
})(); //선언과 동시에 바로 호출됨 (잘 사용되지는 않음)