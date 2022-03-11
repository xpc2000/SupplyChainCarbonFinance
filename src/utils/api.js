import  request from './request.js'
import { postJson, putJson, getJson } from "./helper";

// //查询用户信息
// export const getMessage = (params) => request.get('/getMessage', params );
// //删除用户信息
// export const deleteData = (pasrams) => request.delete('/getCount', params );

// login **
export async function loginVerification(data){
    // return postJson("/user/login", data)
    return request.post('/user/login', data);
}

// 创建碳信
export async function ticketCreate(params){
    return request.post('/ticket/create', params)
}

// 发行碳信
export async function ticketPublish(params){
    return request.post('/ticket/publish', params)
}

// 接收发行碳信
// export const ticketPublishCheck = (params) => request.put('/ticket/publishCheck', params);

// 转让碳信
// export const ticketTransfer = (params) => request.post('/ticket/transfer', params);

// 接收转让碳信
// export const ticketTransferCheck = (params) => request.put('/ticket/transferCheck', params);

// 回购碳信
export async function ticketRepurchase(params){
    return request.post(`/ticket/buyback`, params)
}

// 碳信销毁
export async function ticketDestroy(params){
    return request.post(`/ticket/destroy`, params)
}

// 所有GET METHOD
// 获取特定碳信记录 tobefinished
// export const loadAllTicketList = (params) => request.get('/ticketSearch', params);

// 获取企业需要签收的碳信记录
// export const loadCompanyPendingTicket = (params) => request.get('/ticketSearch/pending', params);

// 获取企业已经签收的碳信记录
// export const loadCompanySignedTicket = (params) => request.get('/ticketSearch/signed', params);

// 获取企业已经拒收的碳信记录
// export const loadCompanyRejectedTicket = (params) => request.get('/ticketSearch/reject', params);

// 获取特定碳质押记录 tobefinished
export async function loadSinglePledgeRow(id){
    return request.get(`/pledgeSearch/${id}`)
}
// export const loadSinglePledgeRow = (params) => request.get('/pledgeSearch', params);

// 获取企业已经提交的碳质押记录
export async function loadCompanySubmittedPledge(chain, company){
    return request.get(`/pledgeSearch/submit?chain=${chain}&company=${company}`, chain, company)
}

// 获取企业可以签约的碳质押记录
export async function loadCompanySigningPledge(chain, company){
    return request.get(`/pledgeSearch/signing-company?chain=${chain}&company=${company}`, chain, company)
}

// 获取金融机构待审批的碳质押记录
export async function loadInstitutionPendingPledge(institution){
    return request.get(`/pledgeSearch/pending?company=${institution}`, institution)
}

// 获取金融机构需要签约的碳质押记录
export async function loadInstitutionSigningPledge(institution){
    return request.get(`/pledgeSearch/signing-institution?company=${institution}`,institution)
}

// 获取特定融资记录 tobefinished
// export const loadAllFactorList = (params) => request.get('/factorSearch', params);

// 获取企业申请中的融资记录
// export const loadCompanyApplyingFactors = (params) => request.get('/factorSearch/applying', params);

// 获取企业可签约的融资记录
// export const loadCompanySigningFactors = (params) => request.get('/factorSearch/signing-company', params);

// 获取金融机构待审批的融资记录
// export const loadInstitutePendingFactors = (params) => request.get('/factorSearch/pending', params);

// 获取金融机构已审批的融资记录
// export const loadInstituteApprovedFactors = (params) => request.get('/factorSearch/approved', params);

// UPDATE AND POST
// 提交减排计划
// export const submitChainPlan = (params) => request.post('/chain/plan', params);

// 控排链企业提交碳质押申请
export async function submitCompanyPledgeApplication(data){
    return request.post('/pledge/apply', data);
}

// 金融机构审核碳质押申请
//ticketVo 
export async function updateInstitutionPledgeExamination(data){
    return request.put('/pledge/examine', data);
}

// 金融机构草拟质押条件并签署合约
// export const updateInstitutionPledgeSigning = (params) => request.put('/pledge/financeSign', params);

// 控排链企业决定是否答应金融机构的贷款条件
export async function updateCompanyPledgeSigning(data, ticketNum){
    return request.put(`/pledge/companySign?ticketNum=${ticketNum}`, data, ticketNum);
}
// export const updateCompanyPledgeSigning = (params) => request.put('/pledge/companySign', params);

// 减排链企业申请供应链金融服务（本demo中以保理为例）
// export const submitCompanyFundApplication = (params) => request.post('/fund/apply', params);

// 金融机构对控排链企业的申请进行合规检查
// export const updateInstitutionFundExamination = (params) => request.put('/fund/Examination', params);

// 金融机构对供应链申请提出融资条件并签约
// export const updateInstitutionFundSigning = (params) => request.put('/fund/financeSign', params);

// 减排链企业决定是否答应金融机构提出的融资条件
// export const updateCompanyFundSigning = (params) => request.put('/fund/companySign', params);

