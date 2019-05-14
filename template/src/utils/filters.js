export function timestamp (time) {
  var date = new Date(time)
  var Y = date.getFullYear()
  var M = date.getMonth() + 1
  var D = date.getDate()
  M = M < 10 ? '0' + M : M
  D = D < 10 ? '0' + D : D
  var h = date.getHours() + ':'
  var m = date.getMinutes()
  m = m < 10 ? '0' + m : m
  return Y + '-' + M + '-' + D + ' ' + h + m
}

// 上面这个是过滤器，你可以把你需要用的的过滤器都放到这里
