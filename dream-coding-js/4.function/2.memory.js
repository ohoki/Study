function add(a, b) {
  console.log(a);
  console.log(b);
  return a + b;
}
const sum = add;
//sum의 변수에 add 함수의 참조값이 할당된다. (같은 함수정의를 가지고 있다.)

console.log(add(1, 2)); //1 2 3
console.log(sum(1, 2)); //1 2 3

console.log(add()); //undefined undefined NaN 

