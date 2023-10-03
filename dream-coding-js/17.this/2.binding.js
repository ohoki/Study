// this 바인딩
// 자바, C#, C++ 대부분의 객체지향 프로그래밍 언어에서는
// this는 항상 자신의 인스턴스 자체를 가리킴!
// 정적으로 인스터스가 만들어지는 시점에 this가 결정됨!(변경불가)
// 하지만 자바스크립트에서는 누가 호출하냐에 따라서 this가 달라짐!
// 즉, 자바스크립트의 this는 호출하는 사람(caller)에 의해 동적으로 결정됨!
function Cat(name) {
  this.name = name;
  this.printName = function() {
    console.log(`고양이의 이름을 출력한다옹: ${this.name}`);
  };
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

dog.printName(); //expected 고양이의 이름을 출력한다옹: 멍멍
//누가 호출하는지에 따라서 인스턴스의 this가 동적으로 변경됨

function printOnMonitor(printName) {
  console.log('모니터를 준비하고!, 전달된 콜백을 실행!');
  printName();
}

printOnMonitor(cat.printName);
// expected  모니터를 준비하고!, 전달된 콜백을 실행!
//           고양이의 이름을 출력한다옹: undefined
// caller가 없기때문에 undefined로 출력되는 걸 볼 수 있다.
// caller에 의해 동적으로 this가 변경된다!!