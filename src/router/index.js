import Vue from 'vue'
import VueRouter from 'vue-router'
// import layout from '@/layout'

Vue.use(VueRouter)

const routes = [
 
  {
    path: '/',
    component: ()=>import('@/layout'),
    children:[
      
      {
        path: '/kongpaiMainEnterprise/p1-company-management-list',
        component: ()=>import('@/views/kongpaiMainEnterprise/p1-company-management-list')
      },
      {
        path: '/kongpaiMainEnterprise/p2-company-management-approval',
        component: ()=>import('@/views/kongpaiMainEnterprise/p2-company-management-approval')
      },
      {
        path: '/kongpaiMainEnterprise/p2-01-company-management-approval-form',
        component: ()=>import('@/views/kongpaiMainEnterprise/p2-01-company-management-approval-form')
      },
      {
        path: '/kongpaiMainEnterprise/p3-kong-account-detail',
        component: ()=>import('@/views/kongpaiMainEnterprise/p3-kong-account-detail')
      },
      {
        path: '/kongpaiMainEnterprise/p4-carbon-credit-created',
        component: ()=>import('@/views/kongpaiMainEnterprise/p4-carbon-credit-created')
      },
      {
        path: '/kongpaiMainEnterprise/p5-carbon-credit-destroyed',
        component: ()=>import('@/views/kongpaiMainEnterprise/p5-carbon-credit-destroyed')
      },
      {
        path: '/kongpaiMainEnterprise/p6-company-carbon-credit-account-detail',
        component: ()=>import('@/views/kongpaiMainEnterprise/p6-company-carbon-credit-account-detail')
      },
      {
        path: '/kongpaiMainEnterprise/p7-carbon-credit-launching',
        component: ()=>import('@/views/kongpaiMainEnterprise/p7-carbon-credit-launching')
      },
      {
        path: '/kongpaiMainEnterprise/p8-carbon-credit-repo-list',
        component: ()=>import('@/views/kongpaiMainEnterprise/p8-carbon-credit-repo-list')
      },
      
      {
        path: '/kongpaiMainEnterprise/p9-pledge-application',
        component: ()=>import('@/views/kongpaiMainEnterprise/p9-pledge-application')
      },
      {
        path: '/kongpaiMainEnterprise/p10-notifications-list',
        component: ()=>import('@/views/kongpaiMainEnterprise/p10-notifications-list')
      },
    ]
  },
  {
    path: '/index2',
    component: ()=>import('@/layout/index2'),
    children:[
      {
        path: '/kongpaiChainEnterprise/p6-company-carbon-credit-account-detail',
        component: ()=>import('@/views/kongpaiChainEnterprise/p6-company-carbon-credit-account-detail')
      },
      {
        path: '/kongpaiChainEnterprise/p7-carbon-credit-launching',
        component: ()=>import('@/views/kongpaiChainEnterprise/p7-carbon-credit-launching')
      },
      {
        path: '/kongpaiChainEnterprise/p8-carbon-credit-repo-list',
        component: ()=>import('@/views/kongpaiChainEnterprise/p8-carbon-credit-repo-list')
      },
      
      {
        path: '/kongpaiChainEnterprise/p9-pledge-application',
        component: ()=>import('@/views/kongpaiChainEnterprise/p9-pledge-application')
      },
      {
        path: '/kongpaiChainEnterprise/p10-notifications-list',
        component: ()=>import('@/views/kongpaiChainEnterprise/p10-notifications-list')
      },
    ]
   
  },
  {
    path: '/index3',
    component: ()=>import('@/layout/index3'),
    children:[
      {
        path: '/jianpaiMainChainEnterprise/p1-company-management-list',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p1-company-management-list')
      },
      {
        path: '/jianpaiMainChainEnterprise/p2-company-carbon-credit-account-detail',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p2-company-carbon-credit-account-detail')
      },
      {
        path: '/jianpaiMainChainEnterprise/p3-carbon-credit-transfer',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p3-carbon-credit-transfer')
      },
      {
        path: '/jianpaiMainChainEnterprise/p4-financing-application',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p4-financing-application')
      },
      {
        path: '/jianpaiMainChainEnterprise/p5-carbon-receiving-task',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p5-carbon-receiving-task')
      },
      {
        path: '/jianpaiMainChainEnterprise/p5-1taskDetail',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p5-1taskDetail')
      },
      {
        path: '/jianpaiMainChainEnterprise/p6-notifications-list',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p6-notifications-list')
      }

     
    ]
   
  },

  {
    path: '/index4',
    component: ()=>import('@/layout/index4'),
    children:[
      {
        path: '/jianpaiLinkedEnterprise/p2-company-carbon-credit-account-detail',
        component: ()=>import('@/views/jianpaiLinkedEnterprise/p2-company-carbon-credit-account-detail')
      },
      {
        path: '/jianpaiLinkedEnterprise/p3-carbon-credit-transfer',
        component: ()=>import('@/views/jianpaiLinkedEnterprise/p3-carbon-credit-transfer')
      },
      {
        path: '/jianpaiLinkedEnterprise/p4-financing-application',
        component: ()=>import('@/views/jianpaiLinkedEnterprise/p4-financing-application')
      },
      {
        path: '/jianpaiLinkedEnterprise/p5-carbon-receiving-task',
        component: ()=>import('@/views/jianpaiLinkedEnterprise/p5-carbon-receiving-task')
      },
      {
        path: '/jianpaiLinkedEnterprise/p5-1taskDetail',
        component: ()=>import('@/views/jianpaiLinkedEnterprise/p5-1taskDetail')
      },
      {
        path: '/jianpaiLinkedEnterprise/p6-notifications-list',
        component: ()=>import('@/views/jianpaiLinkedEnterprise/p6-notifications-list')
      }

     
    ]
   
  },
  {
    path: '/index5',
    component: ()=>import('@/layout/index5'),
    children:[
      {
        path: '/financeInstitute/PledgeAproval',
        component: ()=>import('@/views/financeInstitute/PledgeAproval')
      },
      {
        path: '/financeInstitute/PledgeAprovalDetails',
        component: ()=>import('@/views/financeInstitute/PledgeAprovalDetails')
      },
      {
        path: '/financeInstitute/PledgeSigning',
        component: ()=>import('@/views/financeInstitute/PledgeSigning')
      },
      {
        path: '/financeInstitute/PledgeSigningDetails',
        component: ()=>import('@/views/financeInstitute/PledgeSigningDetails')
      },
      {
        path: '/financeInstitute/ComplianceReview',
        component: ()=>import('@/views/financeInstitute/ComplianceReview')
      },
      {
        path: '/financeInstitute/ComplianceReviewDetails',
        component: ()=>import('@/views/financeInstitute/ComplianceReviewDetails')
      },
      {
        path: '/financeInstitute/FactoringBuying',
        component: ()=>import('@/views/financeInstitute/FactoringBuying')
      },
      {
        path: '/financeInstitute/notificationList',
        component: ()=>import('@/views/financeInstitute/notificationList')
      }
    ]
   
  },

  
]

const router = new VueRouter({
  routes
})

export default router
