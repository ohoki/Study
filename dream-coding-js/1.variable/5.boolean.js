//데이터 타입 - 불리언 (참, 거짓) - MDN-Bollean 타입 읽어보기
//https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Boolean

let 참 = true;
let 거짓=false;

// 활용예 (불리언 타입의 변수는 일반적으로 isXXXX 식으로 이름을 짓는다.)

let isFree = true;
let isActivated = false;
let isEntrolled = true;

//일반 데이터에서 Falshy 거짓인 값
console.log(!!0);
console.log(!!-0);
console.log(!!'');
console.log(!!null);
console.log(!!undefined);
console.log(!!NaN);

//일반 데이터에서 Truthy 참인 값
console.log(!!1);
console.log(!!-1);
console.log(!!'text');
console.log(!!{}); //텅텅 빈 오브젝트
console.log(!!Infinity);
