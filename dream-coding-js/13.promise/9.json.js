// JSON: JavaScript Object Notation
// 서버와 클라이언트(브라우저, 모바일) 간의 HTTP  통신을 위한 
// 오브젝트 형태의 텍스트 포멧
// stringify(object): JSON (object 형태를 JSON으로 변환해 서버에 저장)
// parse(JSON); object (서버에서 받을 때 JSON형태를 object로 변환)

const ellie = {
  name: 'ellie',
  age: 20,
  eat: () => {
    console.log('eat');
  }
};

//직렬화 Serializing: 객체를 문자열로 변환
const json = JSON.stringify(ellie);
console.log(ellie);
console.log(json);
//(함수는 문자열로 변환이 되지 않는다.)

//역직렬화 Deserializing: 문자열 데이터를 자바스크립트 객체로 변환
const obj = JSON.parse(json);
console.log(obj);