function a() {
  return 1;
}

function b() {
  return a() + 1;
}

function c() {
  return b() + 1;
}

const result = c();
console.log(result);

//자바스크립트는 기본적으로 동기적으로 진행된다.
//그래서 오래걸리는 작업을 수행하면 좋지 않다.

