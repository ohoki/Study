//산술 연산자(arithmetic operators)

//+ 더하기
//- 빼기
//* 곱하기
// / 나누기
// % 나머지값
// ** 지수(거듭제곱)

console.log(5 + 2);
console.log(5 - 2);
console.log(5 / 2);
console.log(5 % 2);
console.log(5 ** 2);
console.log(Math.pow(5, 2)); //지수 연산자가 없었을 때 거듭제곱 했던 방식

//+ 연산자 주의점!!

let text = '1' + 1; // 숫자와 문자열을 더하면 문자열로 변환됨
console.log(text); //'11' 문자열로 표시됨

