/**
 * 文字列が空文字かどうかをチェックする
 * @param s 判定する文字列
 * @returns true:空文字 false:空文字ではない
 */
function isEmpty(s) {
	return s === null || s === '' || typeof s === 'undefined';
}