//데이터 타입을 확인하고 값을 문자열 타입으로 반환한다.

let variable;
console.log(typeof variable); //undefined

variable = '';
console.log(typeof variable); //string

variable = 123;
console.log(typeof variable); //number

// 할당된 값에 따라 타입이 결정됨!!
//weakly type => 자바 스크립트 (동적)
//strongly type => 자바 (정적)
