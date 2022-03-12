import  request from './request.js'
import { postJson, putJson, getJson } from "./helper";

// //查询用户信息
// export const getMessage = (params) => request.get('/getMessage', params );
// //删除用户信息
// export const deleteData = (pasrams) => request.delete('/getCount', params );

// login **
// datatype: loginVo
export async function loginVerification(data){
    return request.post('/user/login', data);
}

// 创建碳信
// datatype: TicketVo
export async function ticketCreate(params){
    return request.post('/ticket/create', params)
}

// 发行碳信
// datatype: TicketVo
export async function ticketPublish(params){
    return request.post('/ticket/publish', params)
}

// 接收发行碳信
// datatype: ActionVo, ticketNum(碳信数量)
export async function ticketPublishCheck(params, ticketNum){
    return request.post(`/ticket/publishCheck?ticketNum=${ticketNum}`, params, ticketNum)
}

// 转让碳信 complete
// datatype: TicketVo
export async function ticketTransfer(params){
    return request.post(`/ticket/transfer`, params)
}

// 接收转让碳信
// datatype: ActionVo, ticketNum(碳信数量)
export async function ticketTransferCheck(params){
    return request.put(`/ticket/transferCheck?ticketNum=${ticketNum}`, params, ticketNum)
}

// 回购碳信
// datatype: TicketVo
export async function ticketRepurchase(params){
    return request.post(`/ticket/buyback`, params)
}

// 碳信销毁
// datatype: TicketVo
export async function ticketDestroy(params){
    return request.post(`/ticket/destroy`, params)
}

// 所有GET METHOD
// ***获取特定碳质押记录***
// datatype: 记录id
export async function loadSinglePledgeRow(id){
    return request.get(`/pledgeSearch/${id}`)
}

// ==============================新增代码===========================================
// 获取特定碳信记录 not complete got problemmmmmm
// datatype: 记录id
export async function loadCompanyTicketRow(id){
    return request.get(`/ticketSearch/${id}`)
}

// 获取企业需要签收的碳信记录 
// datatype: 企业所属减排链chain，企业名称company
export async function loadCompanyPendingTicket(chain, company){
    return request.get(`/ticketSearch/pending?chain=${chain}&company=${company}`, chain, company)
}

// 获取企业已经签收的碳信记录
// datatype: 企业所属减排链chain，企业名称company
export async function loadCompanySignedTicket(chain, company){
    return request.get(`/ticketSearch/signed?chain=${chain}&company=${company}`, chain, company)
}

// 获取企业已经拒收的碳信记录
// datatype: 企业所属减排链chain，企业名称company
export async function loadCompanyRejectedTicket(chain, company){
    return request.get(`/ticketSearch/signed?chain=${chain}&company=${company}`, chain, company)
}

// 获取企业已经提交的碳质押记录
// datatype: 企业所属控排链chain，企业名称company
export async function loadCompanySubmittedPledge(chain, company){
    return request.get(`/pledgeSearch/submit?chain=${chain}&company=${company}`, chain, company)
}

// 获取企业可以签约的碳质押记录
// datatype: 企业所属控排链chain，企业名称company
export async function loadCompanySigningPledge(chain, company){
    return request.get(`/pledgeSearch/signing-company?chain=${chain}&company=${company}`, chain, company)
}

// 获取金融机构待审批的碳质押记录
// datatype: 金融机构名称Institution
export async function loadInstitutionPendingPledge(institution){
    return request.get(`/pledgeSearch/pending?company=${institution}`, institution)
}

// 获取金融机构需要签约的碳质押记录
// datatype: 金融机构名称Institution
export async function loadInstitutionSigningPledge(institution){
    return request.get(`/pledgeSearch/signing-institution?company=${institution}`,institution)
}

// 获取特定融资记录 
// datatype: 记录id
export async function loadSingleFactorRow(id){
    return request.get(`/factorSearch/${id}`)
}

// 获取企业申请中的融资记录
// datatype: 企业名称
export async function loadCompanyApplyingFactors(company){
    return request.get(`/factorSearch/applying?company=${company}`,company)
}

// 获取企业可签约的融资记录
// datatype: 企业名称
export async function loadCompanySigningFactors(company){
    return request.get(`/factorSearch/signing-company?company=${company}`, company)
}

// 获取金融机构待审批的融资记录
// datatype: 金融机构名称
export async function loadInstitutePendingFactors(institute){
    return request.get(`/factorSearch/pending?company=${institute}`, institute)
}

// 获取金融机构已审批的融资记录
// datatype: 金融机构名称
export async function loadInstituteApprovedFactors(institute){
    return request.get(`/factorSearch/approved?company=${institute}`, institute)
}

// UPDATE AND POST
// 提交减排计划
// datatype: planVo
export async function submitChainPlan(data){
    return request.post('/chain/plan', data);
}

// 控排链企业提交碳质押申请
// datatype: ActionVo
export async function submitCompanyPledgeApplication(data){
    return request.post('/pledge/apply', data);
}

// 金融机构审核碳质押申请
// datatype: ActionVo
export async function updateInstitutionPledgeExamination(data){
    return request.put('/pledge/examine', data);
}

// 金融机构草拟质押条件并签署合约
// datatype: PledgeVo
export async function updateInstitutionPledgeSigning(data){
    return request.put('/pledge/financeSign', data);
}

// 控排链企业决定是否答应金融机构的贷款条件
// datatype: ActionVo，ticketNum(可创建的碳信额度)
export async function updateCompanyPledgeSigning(data, ticketNum){
    return request.put(`/pledge/companySign?ticketNum=${ticketNum}`, data, ticketNum);
}

// 减排链企业申请供应链金融服务（本demo中以保理为例）
// datatype: ApplyFactorVo
export async function submitCompanyFundApplication(data){
    return request.put(`/fund/apply`, data);
}

// 金融机构对控排链企业的申请进行合规检查
// datatype: ActionVo
export async function updateInstitutionFundExamination(data){
    return request.put(`/fund/Examination`, data);
}

// 金融机构对供应链申请提出融资条件并签约
// datatype: FactorVo
export async function updateInstitutionFundSigning(data){
    return request.put(`/fund/financeSign`, data);
}

// 减排链企业决定是否答应金融机构提出的融资条件
// datatype: ActionVo，ticketNum(碳信数量)
export async function updateCompanyFundSigning(data, ticketNum){
    return request.put(`/fund/companySign?ticketNum=${ticketNum}`, data, ticketNum);
}

