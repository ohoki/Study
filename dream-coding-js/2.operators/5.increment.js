//증가 & 감소 연산자 (Increment & Decrement Operators)

a++; //a=a+1;
a--; //a=a-1;

let a = 0;
console.log(a); // 출력값 0
let b = a++;
console.log(b); // 출력값 0 
console.log(a); // 출력값 1
b = a++;
console.log(b); // 출력값 1 
console.log(a); // 출력값 2

//주의!!! (연산자의 위치에 따라 결과값이 바뀜)
// a++ 필요한 연산을 하고, 그 뒤 값을 증가시킴
// ++a 값을 먼저 증가하고, 필요한 연산을 함