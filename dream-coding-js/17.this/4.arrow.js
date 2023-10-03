// 자바스크립트의 함수는 만능 슈퍼맨!!
// 함수처럼 사용, 생성자 함수로 사용(클래스)
// 하지만, 이걸 위해서 불필요한 무거운 
// 프로토타입(많은 데이터를 담고 있는 객체) 객체가 생성됨
const dog = {
  name: 'Dog',
  play: function () {
    console.log('논다멍');
  },
};

dog.play();
const obj1 = new dog.play(); //함수가 생성자 함수처럼도 사용될 수 있음
console.log(obj1);
// 함수 내부에 자체적으로 더 무거운 프로토타입을 가지고 있어 좋지 않다
// 이를 개선하기 위해 나온게 메소드!!

const cat = {
  name: 'cat',
  play() {   //객체의 메소드 (오브젝트에 속한 함수라는 표현)
    console.log('냐옹');
  },
};
cat.play();
// const obj2 = new cat.play();  //생성자 함수로 사용할 수 없음

/** 
 * 화살표 함수의 장점
 * 1. 문법이 깔끔함
 * 2. 생성자 함수로 사용이 불가능 (무거운 프로토타입을 만들지 않음)
 * 3. 함수 자체 arguments 객체도 가지고 있지 않음
 * 4. this에 대한 바인딩이 정적으로 결정됨
 *    - 함수에서 제일 근접한 상위 스코프의 this에 정적으로 바인딩됨
 */

function sum(a, b) {
  console.log(arguments);
};
sum(1,2); //expected [Arguments] { '0': 1, '1': 2 }

const add = () => {
  console.log(arguments); // arrow함수 외부의 arguments를 참조만 함
};
add(1,2);

const printArrow = () => {
  console.log(this); // arrow함수 외부의 this를 참조만 함
};

cat.printArrow = printArrow;
cat.printArrow();