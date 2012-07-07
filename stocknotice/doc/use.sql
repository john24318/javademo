/* 通知表 */
INSERT INTO sn_notice(notice_id, user_id, stock_id, title, content, flag, email_result, sms_result, create_time)
	SELECT IFNULL(MAX(notice_id), 0)+1, user_id, stock_id, title, content, flag, email_result, sms_result, create_time FROM sn_notice
UPDATE sn_notice SET flag=? WHERE notice_id=?
SELECT notice_id, user_id, stock_id, title, content, flag, email_result, sms_result, create_time FROM sn_notice
SELECT email, login, title, content FROM sn_notice n, sn_user u WHERE n.flag=0 AND n.user_id=u.user_id
DELETE FROM sn_notice
UPDATE sn_notice SET flag=1 WHERE notice_id=1

/* 股票表 */
INSERT INTO sn_stock(stock_id, user_id, stock_name, stock_code, min_price, max_price, buy_notice_flag, sell_notice_flag)
	SELECT IFNULL(MAX(stock_id), 0)+1, 1, '招商银行', 'SHA:600036', 15.25, 17, 0, 0 FROM sn_stock;
INSERT INTO sn_stock(stock_id, user_id, stock_name, stock_code, min_price, max_price, buy_notice_flag, sell_notice_flag)
	SELECT IFNULL(MAX(stock_id), 0)+1, 1, '华侨城A', 'SHE:000069', 15, 16, 0, 0 FROM sn_stock;
INSERT INTO sn_stock(stock_id, user_id, stock_name, stock_code, min_price, max_price, buy_notice_flag, sell_notice_flag)
	SELECT IFNULL(MAX(stock_id), 0)+1, 1, '中国联通', 'SHA:600050', 6.5, 8, 0, 0 FROM sn_stock;
INSERT INTO sn_stock(stock_id, user_id, stock_name, stock_code, min_price, max_price, buy_notice_flag, sell_notice_flag)
	SELECT IFNULL(MAX(stock_id), 0)+1, 1, '厦门空港', 'SHA:600897', 16, 21, 0, 0 FROM sn_stock;
INSERT INTO sn_stock(stock_id, user_id, stock_name, stock_code, min_price, max_price, buy_notice_flag, sell_notice_flag)
	SELECT IFNULL(MAX(stock_id), 0)+1, 1, '中国中铁', 'SHA:601390', 5.65, 6, 0, 0 FROM sn_stock;
INSERT INTO sn_stock(stock_id, user_id, stock_name, stock_code, min_price, max_price, buy_notice_flag, sell_notice_flag)
	SELECT IFNULL(MAX(stock_id), 0)+1, 2, '招商银行', 'SHA:600036', 13, 20, 0, 0 FROM sn_stock;
INSERT INTO sn_stock(stock_id, user_id, stock_name, stock_code, min_price, max_price, buy_notice_flag, sell_notice_flag)
	SELECT IFNULL(MAX(stock_id), 0)+1, 3, '马钢股份', 'SHA:600808', 3.56, 4.5, 0, 0 FROM sn_stock;
SELECT stock_id AS stockId, user_id AS userId, stock_name AS stockName, stock_code AS stockCode, min_price AS minPrice, max_price AS maxPrice, buy_notice_flag AS buyNoticeFlag, sell_notice_flag AS sellNoticeFlag
FROM sn_stock WHERE buy_notice_flag=0 OR sell_notice_flag=0
SELECT DISTINCT stock_code AS stockCode FROM sn_stock WHERE buy_notice_flag=0 OR sell_notice_flag=0
UPDATE sn_stock SET buy_notice_flag=? WHERE stock_id IN ()

/* 用户表 */
INSERT INTO sn_user(user_id, login, PASSWORD, email, mobile_phone_number, registered, active_code, state)
	SELECT IFNULL(MAX(user_id), 0)+1, 'lyz', '123456', 'gigi.luck@gmail.com', '13570813200', NOW(), '123', 1 FROM sn_user;
SELECT user_id AS userId, login, PASSWORD, email, mobile_phone_number AS mobilePhoneNumber, registered, active_code AS activeCode, state, last_login_time AS lastLoginTime, last_login_ip AS lastLoginIp
FROM sn_user WHERE login=''
UPDATE sn_user SET state=? WHERE user_id=?

