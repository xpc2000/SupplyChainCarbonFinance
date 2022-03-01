<template>

    <el-descriptions >
            <el-descriptions-item label="editableText.label">
        
            <span v-show="!editableText.edit">{{ editableText.input }}</span>
            <el-input v-show="editableText.edit" v-model=editableText.input></el-input>
            <i
              :class="{'el-icon-edit': !editableText.edit, 'el-icon-check': editableText.edit}"
              @click="editableText.edit = !editableText.edit"
            ></i>
          </el-descriptions-item>
         
           
        </el-descriptions>
   

   
</template>

<script>

export default{
   
    props:["editableText"]
}
</script>

<style scoped>


</style>