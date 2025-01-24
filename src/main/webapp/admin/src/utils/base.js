const base = {
    get() {
        return {
            url : "http://localhost:8080/lhcnyxxglxt/",
            name: "lhcnyxxglxt",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lhcnyxxglxt/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "莲花村农业信息管理系统"
        } 
    }
}
export default base
