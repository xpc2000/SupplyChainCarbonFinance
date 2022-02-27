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
        path: '/p1-company-management-list',
        component: ()=>import('@/views/p1-company-management-list')
      },
      {
        path: '/p2-company-management-approval',
        component: ()=>import('@/views/p2-company-management-approval')
      },
      {
        path: '/p2-01-company-management-approval-form',
        component: ()=>import('@/views/p2-01-company-management-approval-form')
      },
      {
        path: '/p3-kong-account-detail',
        component: ()=>import('@/views/p3-kong-account-detail')
      },
      {
        path: '/p4-carbon-credit-created',
        component: ()=>import('@/views/p4-carbon-credit-created')
      },
      {
        path: '/p5-carbon-credit-destroyed',
        component: ()=>import('@/views/p5-carbon-credit-destroyed')
      },
      {
        path: '/p6-company-carbon-credit-account-detail',
        component: ()=>import('@/views/p6-company-carbon-credit-account-detail')
      },
      {
        path: '/p7-carbon-credit-launching',
        component: ()=>import('@/views/p7-carbon-credit-launching')
      },
      {
        path: '/p8-carbon-credit-repo-list',
        component: ()=>import('@/views/p8-carbon-credit-repo-list')
      },
      
      {
        path: '/p9-pledge-application',
        component: ()=>import('@/views/p9-pledge-application')
      },
      {
        path: '/p10-notifications-list',
        component: ()=>import('@/views/p10-notifications-list')
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
        path: '/jianpaiMainChainEnterprise/p6-notifications-list',
        component: ()=>import('@/views/jianpaiMainChainEnterprise/p6-notifications-list')
      }

     
    ]
   
  },

  
]

const router = new VueRouter({
  routes
})

export default router
