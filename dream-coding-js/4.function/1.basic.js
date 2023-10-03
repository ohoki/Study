//함수 정의
function add(num1, num2) {
  return num1 + num2;
}
//함수 호출
const result = add(1, 2); //(그냥 add(1,2);만 해도 됨)
console.log(result);


//사용예제 
function fullName(firstName, lastName) {
  return `${firstName} ${lastName}`; // 템플릿 리터럴
}
let lastName = '김';
let firstName = '지수';
console.log(fullName(firstName, lastName));

let lastName2 = '박';
let firstName2 = '철수';
console.log(fullName(firstName2, lastName2));

//함수를 사용하면 수정이 편하고 반복적인 일을 줄이기 위해 함수를 적용할 수 있다.