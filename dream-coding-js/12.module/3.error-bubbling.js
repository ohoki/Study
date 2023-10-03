// Bubbling up, Propagating
function a() {
  throw new Error('error!');
}

function b() {
  try {
    a();
  } catch(error) {
    console.log('이 에러는 내가 잡을 수 없겠군!!');
    throw error;
  }
}

function c() {
  b();
}

try {
  c();
} catch (error) {
  console.log('Catched!!');
}
console.log('done!');