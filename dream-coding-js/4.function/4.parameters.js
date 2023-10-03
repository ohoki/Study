//매개변수 (Parameter), 매개변수에 집어 넣는 값 (Argument)

//매개변수의 기본값은 무조건 undefined 
//매개변수 기본값(Default Parameters) 변경 가능 - function add(a=1,b=1) {}
//매개변수의 정보는 함수 내부에서 접근이 가능한 arguments 객체에 저장됨


function add(a, b) {
  console.log(a); //1
  console.log(b); //2
  console.log(arguments); // {'0':1, '1':2, '2':3}
  console.log(arguments[1]); //2
  return a + b;//3
}
add(1, 2, 3);

//Rest 매개변수(Rest Parameters)
function sum(...numbers) {
  console.log(numbers);
}
sum(1, 2, 3, 4, 5, 6, 7, 8); //[1, 2, 3, 4, 5, 6, 7, 8] 배열을 표기하는 방법
