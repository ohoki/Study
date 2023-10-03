function Cat(name) {
  this.name = name;
  this.printName = function() {
    console.log(`고양이의 이름을 출력한다옹: ${this.name}`);
  };
  // 정적인 바인딩으로 변경하는 방법
// 1. bind 함수를 이용해서 수동적으로 바인딩 해주기
  this.printName = this.printName.bind(this);
// 2. 화살표 함수로 변경하는 방법 : arrow 함수는 렉시컬 환경에서의 this를 기억함!
//    화살표 함수 밖에서 제일 근접한 스코프의 this를 가리킴
//   this.printName =  () => {
//   console.log(`고양이의 이름을 출력한다옹: ${this.name}`);
// };
};


function Dog(name) {
  this.name = name;
  this.printName = function() {
    console.log(`강아지의 이름을 출력한다멍: ${this.name}`);
  };
};

const cat = new Cat('냐옹');
const dog = new Dog('멍멍');
cat.printName();
dog.printName();

dog.printName = cat.printName;

dog.printName(); //expected 고양이의 이름을 출력한다옹: 냐옹
//this 바인딩을 정적으로 만들어주면서 '냐옹'이 출력됨 (객체와 꽁꽁 묶여버림)

function printOnMonitor(printName) {
  console.log('모니터를 준비하고!, 전달된 콜백을 실행!');
  printName();
}

printOnMonitor(cat.printName);
// expected  모니터를 준비하고!, 전달된 콜백을 실행!
//           고양이의 이름을 출력한다옹: undefined
// caller가 없기때문에 undefined로 출력되는 걸 볼 수 있다.
// caller에 의해 동적으로 this가 변경된다!!