//Nullish Coalescing Operator
//ES11
//?? (null, undefined인 경우에 실행한다)
let num = 0;
console.log(num || '-1'); // num이 출력되게 하고싶지만 0은 falshy 값이라서 -1이 출력됨
console.log(num ?? '-1'); // 0이 출력됨



