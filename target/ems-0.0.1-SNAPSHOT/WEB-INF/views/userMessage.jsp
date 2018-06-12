<%@ page import="java.util.List" %>
<%@ page import="com.channelsoft.ems.po.MessagePo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>个人资料</title>
	
	    <link rel="shortcut icon" href="favicon.ico"> 
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

<body class="gray-bg">
<div class="modal-content">
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">用户资料</h4>
	</div>
	<div class="modal-body" style="height: 550px;">
		<div class="popover-content" style="width: 1000px;">
			<table style="width: 950px;position: relative; top: -30px;">
				<tbody>
				<%List list1=(List)request.getAttribute("list1");
					MessagePo po=(MessagePo)list1.get(0);

				%>
				<tr>
					<td></td>
					<td></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td rowspan="8" style="text-align: center;vertical-align: middle;">

						<img id="Imagel1" src="${pageContext.request.contextPath}\\img\\<%=po.getfPhotoID()%>" style="height: 135px;width: 110px;">
					</td>
				</tr>
				<tr>
					<td align="right">姓名：</td>
					<td>
						<input name="textName" value="<%=po.getfStaffName()%>" type="text" maxlength="3" id="updatetxtName" readonly="readonly" required style="width: 90px;height: 23px">
					</td>
					<td align="right">性别：</td>
					<td>
						<input name="dropSex" value="<%=po.getfSex()%>" id="updateSex" class="input_text" readonly="readonly" style="width: 90px;height: 23px">


					</td>
					<td align="right">&nbsp;状态：</td>
					<td>
						<input  name="dropStature" value="<%=po.getfStaffStatus()%>" id="updateStature"   readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">民族：</td>
					<td>
						<input name="nation" value="<%=po.getfFnation()%>"   id="updateNation" class="input_text"  readonly="readonly" style="width: 90px;height: 23px">

					</td>
				</tr>
				<tr>
					<td align="right">部门：</td>
					<td>
						<input  name="emp" value="<%=po.getfDepartmentName()%>" id="updateDepartment" readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">职务：</td>
					<td>
						<input name="duty" value="<%=po.getfPost()%>"  id="updateDuty" readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">职称：</td>
					<td>
						<input name="jobTitle" value="<%=po.getfTitle()%>"  id="updateTitle" readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">薪资类别：</td>
					<td>
						<input name="sal" value="<%=po.getfSalryType()%>" id="updateSal" readonly="readonly" style="width: 90px;height: 23px">

					</td>
				</tr>
				<tr>
					<td align="right">身份证号：</td>
					<td>
						<input name="idCard" value="<%=po.getfIdentityCardID()%>" id="updateIdentityCardID" type="text" maxlength="18" readonly="readonly"   style="width: 205px;height: 23px">

					</td>
					<td align="right">出生日期：</td>
					<td>
						<input   type="text" value="<%=po.getfBrith()%>"  id="updateBirth" readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">婚姻状况</td>
					<td>
						<input name="marry"  value="<%=po.getfMaritalStatus()%>" id="updateMaritalStatus" readonly="readonly" style="width: 90px;height: 23px">

						</td>
					<td align="right">健康状况</td>
					<td>
						<input name="health" value="<%=po.getfHealth()%>"  type="text" maxlength="20" id="updateHealth"  readonly="readonly"  style="width: 90px;height: 23px">

						</td>
				</tr>
				<tr>
					<td align="right">政治面貌：</td>
					<td>
						<input name="political"value="<%=po.getfPoliticalStatus()%>" type="text" maxlength="20" id="updatePoliticalStatus"  readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">入职日期：</td>
					<td>
						<input   type="text" id="updateEntryDate"  value=" <%=po.getfEntryDate()%>" readonly="readonly" style="width: 90px;height: 23px">

					</td>

					<td align="right">解聘日期：</td>
					<td>
						<input  type="text" id="updateDismissalDate"  value="<%=po.getfDismissalDate()%>" readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">户籍：</td>
					<td>
						<input name="census" value=" <%=po.getfHpisejpldRegister()%>" type="text" maxlength="40" id="updateCensus"  readonly="readonly" style="width: 90px;height: 23px">

					</td>
				</tr>
				<tr>
					<td align="right">毕业院校：</td>
					<td>
						<input name="school" value="<%=po.getfGraduateSchool()%>"  type="text" maxlength="40" id="updateGraduateSchool" readonly="readonly" style="width: 90px;height: 23px">
					</td>
					<td align="right">学历：</td>
					<td>
						<input name="education" value="  <%=po.getfEducation()%>" id="updateEducation"  readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">专业：</td>
					<td>
						<input name="major" value="<%=po.getfMajor()%>" type="text" maxlength="40" id="updateMajor" readonly="readonly"  style="width: 90px;height: 23px">


					</td>
					<td align="right">电脑水平：</td>
					<td>
						<input name="computer" value="<%=po.getfComputerLevel()%>" id="updateComputer" readonly="readonly" style="width: 90px;height: 23px">

					</td>
				</tr>
				<tr>
					<td align="right">所持证书：</td>
					<td>
						<input name="usbKey" value="<%=po.getfCertificate()%>" type="text" maxlength="200" id="updateCertificate"  readonly="readonly"  style="width: 90px;height: 23px">
					</td>
					<td align="right">外语水平：</td>
					<td>
						<input name="foreign" value=" <%=po.getfLanguageLevel()%>" id="updateLanguageLevel" readonly="readonly"  style="width: 90px;height: 23px">

					</td>
					<td align="right">所属大厦：</td>
					<td>
						<input  name="FBuildingID" value="<%=po.getfBuildingName()%>" id="updateBuildingID" readonly="readonly"  style="width: 90px;height: 23px">

					</td>
					<td align="right">手机：</td>
					<td>
						<input  name="FMobileTel" value="<%=po.getfMobileTel()%>" type="text" maxlength="11" id="updateMobileTel"  readonly="readonly"  style="width: 90px;height: 23px">

						</td>
				</tr>
				<tr>
					<td align="right">银行卡号：</td>
					<td>
						<input  name="cardId" value="<%=po.getfBankCardID()%>" type="text" maxlength="19" id="updateBankCard"   readonly="readonly" style="width: 205px;height: 23px">

					</td>
					<td align="right">固定电话：</td>
					<td>
						<input name="FTel" value="<%=po.getfTel()%>" type="text" maxlength="11" id="updateTel" readonly="readonly" style="width: 90px;height: 23px">

					</td>
					<td align="right">邮政编号：</td>
					<td>
						<input name="FPostcode" value="<%=po.getfPostcode()%>" type="text" maxlength="11" id="updatePostcode"  readonly="readonly" style="width: 90px;height: 23px">

						</td>
					<td align="right">微信号：</td>
					<td>
						<input name="FWechatNumber" value=" <%=po.getfWechatNumber()%>"  type="text" maxlength="11" id="updateWechatNumber"  readonly="readonly" style="width: 90px;height: 23px">

					</td>
				</tr>
				<tr>
					<td align="right">通讯地址：</td>
					<td colspan="8">
						<input name="Phone" value="<%=po.getfHomeAddress()%>" type="text" maxlength="200" id="updateMalingAddress"  readonly="readonly" style="width: 710px;height: 23px">

					</td>
				</tr>
				<tr>
					<td align="right">备注：</td>
					<td colspan="8">
						<input name="remark" value=" <%=po.getfRemarks()%>" type="text" maxlength="200" id="updateRemark"  readonly="readonly" style="width: 710px;height: 23px">

					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>



    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/rate-range/rateRange.js"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
	
    <!-- Bootstrap table -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript">
			var contextPath = "${pageContext.request.contextPath}";

	</script>

</body>
</html>
