/**
 * 글로벌 컨텍스트의 this
 * - 브라우저: 윈도우
 * - 노드: 모듈
 */

const x = 0;
module.exports.x = x;
console.log(this); // expected { x: 0 }

//-----------------------------------------------------

/** 
 * 함수 내부에서의 this
 * 엄격모드가 아닌 경우에는 globalThis 로 인식
 * 엄격모드에서는 undefined
 */

function fun() {
  console.log(this);
};
fun();

/**
 * 생성자 함수 또는 클래스에서의 this, 앞으로 생성될 인스턴스 자체를 가리킴
 */
function Cat(name) {
  this.name = name;
  this.printName = function() {
    console.log(this.name);
  };
};
const cat1 = new Cat('냐옹');
const cat2 = new Cat('야옹');
console.log(cat1);
console.log(cat2);