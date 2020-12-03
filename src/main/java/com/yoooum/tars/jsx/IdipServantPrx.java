// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.jsx;

import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.annotation.*;
import com.qq.tars.common.support.Holder;

@Servant
public interface IdipServantPrx {
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件类型
	 * @param(output), stMailItem 邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public int SendMail(java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecFailAccountID);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件类型
	 * @param(output), stMailItem 邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public int SendMail(java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecFailAccountID, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件类型
	 * @param(output), stMailItem 邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public void async_SendMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件类型
	 * @param(output), stMailItem 邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public void async_SendMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 删除邮件数据
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件ID
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public int DelMail(java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecFailAccountID);
	/**
	 * 删除邮件数据
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件ID
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public int DelMail(java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecFailAccountID, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 删除邮件数据
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件ID
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public void async_DelMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId);
	/**
	 * 删除邮件数据
	 * @param(input), vecAccountID 用户名
	 * @param(input), iMailId 邮件ID
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public void async_DelMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, int iMailId, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 拉取玩家TAccountData数据
	 * @param(input), vecAccountID 用户名
	 * @param(output), stAccountData 数据
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public int QueryPlayerData(com.yoooum.tars.account.TAccountID stAccountID, @TarsHolder Holder<com.yoooum.tars.account.TAccountData> stAccountData);
	/**
	 * 拉取玩家TAccountData数据
	 * @param(input), vecAccountID 用户名
	 * @param(output), stAccountData 数据
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public int QueryPlayerData(com.yoooum.tars.account.TAccountID stAccountID, @TarsHolder Holder<com.yoooum.tars.account.TAccountData> stAccountData, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 拉取玩家TAccountData数据
	 * @param(input), vecAccountID 用户名
	 * @param(output), stAccountData 数据
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public void async_QueryPlayerData(@TarsCallback IdipServantPrxCallback callback, com.yoooum.tars.account.TAccountID stAccountID);
	/**
	 * 拉取玩家TAccountData数据
	 * @param(input), vecAccountID 用户名
	 * @param(output), stAccountData 数据
	 * @返回值：返回 0 成功,  其它 失败
	 */
	public void async_QueryPlayerData(@TarsCallback IdipServantPrxCallback callback, com.yoooum.tars.account.TAccountID stAccountID, @TarsContext java.util.Map<String, String> ctx);

	public int QueryPalyerGameData(long uUin, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TPlayerRoleInfo>> vecPlayerGameInfo);

	public int QueryPalyerGameData(long uUin, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TPlayerRoleInfo>> vecPlayerGameInfo, @TarsContext java.util.Map<String, String> ctx);

	public void async_QueryPalyerGameData(@TarsCallback IdipServantPrxCallback callback, long uUin);

	public void async_QueryPalyerGameData(@TarsCallback IdipServantPrxCallback callback, long uUin, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public int PlatSendMail(java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecFailAccountID);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public int PlatSendMail(java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.account.TAccountID>> vecFailAccountID, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public void async_PlatSendMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	public void async_PlatSendMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.account.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName, @TarsContext java.util.Map<String, String> ctx);
}