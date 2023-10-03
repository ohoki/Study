const obj = {
  name: '영호',
  age: 31,
};

// 코딩하는 시점에, 정적으로 접근이 확정됨
obj.name;
obj.age;

// 동적으로 속성에 접근하고 싶을 때 대괄호 표기법 사용!!
function getValue(obj, key) {
  return obj[key];
}

console.log(getValue(obj, 'name')); //영호

//key,value 추가도 가능
function addKey(obj, key, value) {
  obj[key] = value;
};

addKey(obj, 'job', 'engineer');
console.log(obj);         //{ name: '영호', age: 31, job: 'engineer' }

function deleteKey(obj, key) {
  delete obj[key];
}

deleteKey(obj, 'job');
console.log(obj);           //{ name: '영호', age: 31 }


// MDN 객체로 작업하기 참고하기 - https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/Working_with_Objects