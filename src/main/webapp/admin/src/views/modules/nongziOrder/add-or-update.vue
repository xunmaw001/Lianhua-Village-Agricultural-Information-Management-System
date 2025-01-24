<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='nongzi'">
                    <el-form-item class="select" v-if="type!='info'"  label="农资" prop="nongziId">
                        <el-select v-model="ruleForm.nongziId" :disabled="ro.nongziId" filterable placeholder="请选择农资" @change="nongziChange">
                            <el-option
                                    v-for="(item,index) in nongziOptions"
                                    v-bind:key="item.id"
                                    :label="item.nongziName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='nongzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="农资名称" prop="nongziName">
                        <el-input v-model="nongziForm.nongziName"
                                  placeholder="农资名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="农资名称" prop="nongziName">
                            <el-input v-model="ruleForm.nongziName"
                                      placeholder="农资名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='nongzi' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.nongziPhoto" label="农资照片" prop="nongziPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (nongziForm.nongziPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.nongziPhoto" label="农资照片" prop="nongziPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.nongziPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='nongzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="农资类型" prop="nongziValue">
                        <el-input v-model="nongziForm.nongziValue"
                                  placeholder="农资类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="农资类型" prop="nongziValue">
                            <el-input v-model="ruleForm.nongziValue"
                                      placeholder="农资类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhongzhihu'">
                    <el-form-item class="select" v-if="type!='info'"  label="种植户" prop="zhongzhihuId">
                        <el-select v-model="ruleForm.zhongzhihuId" :disabled="ro.zhongzhihuId" filterable placeholder="请选择种植户" @change="zhongzhihuChange">
                            <el-option
                                    v-for="(item,index) in zhongzhihuOptions"
                                    v-bind:key="item.id"
                                    :label="item.zhongzhihuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='zhongzhihu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="种植户姓名" prop="zhongzhihuName">
                        <el-input v-model="zhongzhihuForm.zhongzhihuName"
                                  placeholder="种植户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="种植户姓名" prop="zhongzhihuName">
                            <el-input v-model="ruleForm.zhongzhihuName"
                                      placeholder="种植户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="订单编号" prop="nongziOrderUuidNumber">
                       <el-input v-model="ruleForm.nongziOrderUuidNumber"
                                 placeholder="订单编号" clearable  :readonly="ro.nongziOrderUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="订单编号" prop="nongziOrderUuidNumber">
                           <el-input v-model="ruleForm.nongziOrderUuidNumber"
                                     placeholder="订单编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            <input id="nongziId" name="nongziId" type="hidden">
            <input id="zhongzhihuId" name="zhongzhihuId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="购买数量" prop="buyNumber">
                       <el-input v-model="ruleForm.buyNumber"
                                 placeholder="购买数量" clearable  :readonly="ro.buyNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="购买数量" prop="buyNumber">
                           <el-input v-model="ruleForm.buyNumber"
                                     placeholder="购买数量" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="地址" prop="nongziOrderDizhi">
                       <el-input v-model="ruleForm.nongziOrderDizhi"
                                 placeholder="地址" clearable  :readonly="ro.nongziOrderDizhi"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="地址" prop="nongziOrderDizhi">
                           <el-input v-model="ruleForm.nongziOrderDizhi"
                                     placeholder="地址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
<!--               <el-col :span="12">-->
<!--                   <el-form-item class="input" v-if="type!='info'"  label="实付价格" prop="nongziOrderTruePrice">-->
<!--                       <el-input v-model="ruleForm.nongziOrderTruePrice"-->
<!--                                 placeholder="实付价格" clearable  :readonly="ro.nongziOrderTruePrice"></el-input>-->
<!--                   </el-form-item>-->
<!--                   <div v-else-if="type=='info'">-->
<!--                       <el-form-item class="input" label="实付价格" prop="nongziOrderTruePrice">-->
<!--                           <el-input v-model="ruleForm.nongziOrderTruePrice"-->
<!--                                     placeholder="实付价格" readonly></el-input>-->
<!--                       </el-form-item>-->
<!--                   </div>-->
<!--               </el-col>-->
<!--               <el-col :span="12">-->
<!--                   <el-form-item class="input" v-if="type!='info'"  label="快递公司" prop="nongziOrderCourierName">-->
<!--                       <el-input v-model="ruleForm.nongziOrderCourierName"-->
<!--                                 placeholder="快递公司" clearable  :readonly="ro.nongziOrderCourierName"></el-input>-->
<!--                   </el-form-item>-->
<!--                   <div v-else-if="type=='info'">-->
<!--                       <el-form-item class="input" label="快递公司" prop="nongziOrderCourierName">-->
<!--                           <el-input v-model="ruleForm.nongziOrderCourierName"-->
<!--                                     placeholder="快递公司" readonly></el-input>-->
<!--                       </el-form-item>-->
<!--                   </div>-->
<!--               </el-col>-->
<!--               <el-col :span="12">-->
<!--                   <el-form-item class="input" v-if="type!='info'"  label="快递单号" prop="nongziOrderCourierNumber">-->
<!--                       <el-input v-model="ruleForm.nongziOrderCourierNumber"-->
<!--                                 placeholder="快递单号" clearable  :readonly="ro.nongziOrderCourierNumber"></el-input>-->
<!--                   </el-form-item>-->
<!--                   <div v-else-if="type=='info'">-->
<!--                       <el-form-item class="input" label="快递单号" prop="nongziOrderCourierNumber">-->
<!--                           <el-input v-model="ruleForm.nongziOrderCourierNumber"-->
<!--                                     placeholder="快递单号" readonly></el-input>-->
<!--                       </el-form-item>-->
<!--                   </div>-->
<!--               </el-col>-->
<!--                <el-col :span="12">-->
<!--                    <el-form-item class="select" v-if="type!='info'"  label="订单类型" prop="nongziOrderTypes">-->
<!--                        <el-select v-model="ruleForm.nongziOrderTypes" :disabled="ro.nongziOrderTypes" placeholder="请选择订单类型">-->
<!--                            <el-option-->
<!--                                v-for="(item,index) in nongziOrderTypesOptions"-->
<!--                                v-bind:key="item.codeIndex"-->
<!--                                :label="item.indexName"-->
<!--                                :value="item.codeIndex">-->
<!--                            </el-option>-->
<!--                        </el-select>-->
<!--                    </el-form-item>-->
<!--                    <div v-else-if="type=='info'">-->
<!--                        <el-form-item class="input" label="订单类型" prop="nongziOrderValue">-->
<!--                        <el-input v-model="ruleForm.nongziOrderValue"-->
<!--                            placeholder="订单类型" readonly></el-input>-->
<!--                        </el-form-item>-->
<!--                    </div>-->
<!--                </el-col>-->
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                nongziForm: {},
                zhongzhihuForm: {},
                ro:{
                    nongziOrderUuidNumber: true,
                    nongziId: false,
                    zhongzhihuId: false,
                    buyNumber: false,
                    nongziOrderDizhi: false,
                    nongziOrderTruePrice: false,
                    nongziOrderCourierName: false,
                    nongziOrderCourierNumber: false,
                    nongziOrderTypes: false,
                    insertTime: false,
                },
                ruleForm: {
                    nongziOrderUuidNumber: new Date().getTime(),
                    nongziId: '',
                    zhongzhihuId: '',
                    buyNumber: '',
                    nongziOrderDizhi: '',
                    nongziOrderTruePrice: '',
                    nongziOrderCourierName: '',
                    nongziOrderCourierNumber: '',
                    nongziOrderTypes: '',
                    insertTime: '',
                },
                nongziOrderTypesOptions : [],
                nongziOptions : [],
                zhongzhihuOptions : [],
                rules: {
                   nongziOrderUuidNumber: [
                              { required: true, message: '订单编号不能为空', trigger: 'blur' },
                          ],
                   nongziId: [
                              { required: true, message: '农资不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhongzhihuId: [
                              { required: true, message: '种植户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   buyNumber: [
                              { required: true, message: '购买数量不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   nongziOrderDizhi: [
                              { required: true, message: '地址不能为空', trigger: 'blur' },
                          ],
                   // nongziOrderTruePrice: [
                   //            { required: true, message: '实付价格不能为空', trigger: 'blur' },
                   //            {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                   //                message: '只允许输入整数6位,小数2位的数字',
                   //                trigger: 'blur'
                   //            }
                   //        ],
                   // nongziOrderCourierName: [
                   //            { required: true, message: '快递公司不能为空', trigger: 'blur' },
                   //        ],
                   // nongziOrderCourierNumber: [
                   //            { required: true, message: '快递单号不能为空', trigger: 'blur' },
                   //        ],
                   // nongziOrderTypes: [
                   //            { required: true, message: '订单类型不能为空', trigger: 'blur' },
                   //            {  pattern: /^[0-9]*$/,
                   //                message: '只允许输入整数',
                   //                trigger: 'blur'
                   //            }
                   //        ],
                   insertTime: [
                              { required: true, message: '订单创建时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }else{
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=nongzi_order_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.nongziOrderTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `nongzi/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.nongziOptions = data.data.list;
            }
         });
         this.$http({
             url: `zhongzhihu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.zhongzhihuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            nongziChange(id){
                this.$http({
                    url: `nongzi/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.nongziForm = data.data;
                    }
                });
            },
            zhongzhihuChange(id){
                this.$http({
                    url: `zhongzhihu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhongzhihuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `nongziOrder/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.nongziChange(data.data.nongziId)
                        _this.zhongzhihuChange(data.data.zhongzhihuId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                  this.ruleForm.nongziOrderTypes=101
                    if (valid) {
                        this.$http({
                            url:`nongziOrder/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.nongziOrderCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.nongziOrderCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

