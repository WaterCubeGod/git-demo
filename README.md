# git-demo
#### 这是一套《在线课程申请及审批系统》，系统概要设计如下：

###### 1. 在线课程申请模块功能：

- __学生登录功能__

  已有账号学生可以在线登录到申请系统中。

  

  用户账户数据可预先存储到数据库中。

- __在线申请功能__

  学生登录后，在可选课程列表中，选择要申请的课程。

  

  每次申请只能选择一门课程，不可重复申请。

  

  申请课程时，应填写必要的申请信息，如：申请原因、上传证明等。

  

  课程详细数据可预先存储到数据库中。

- __已申请课程，审批进度查询功能__

  审批过程中的申请可以进行进度查询。

  

  审批状态有：申请已提交、课程主讲教师审批中、课程主管教师审批中、审批成功、申请驳回。

  

  审批结束后，也就是审批状态为成功或者驳回，学生可以点击确认，完成本次申请。

  

  结束本次申请后，在进度查询功能中不能再看到该条申请信息。

  

  被驳回申请的课程，可线下沟通后，再次重新提交新的申请。

- __已申请课程审批记录查询功能__

  学生可查询本人已申请的全部记录，包括审批通过和驳回的记录。

  

  申请记录可使用分页显示，可使用多条件查询。

###### 2. 在线审批模块功能：

- __课程申请审批功能__

  已有教师角色账号的教师可登录审批功能。

  

  教师角色用户细分为：课程主讲教师和主管教师，主讲教师为该门课程的第一审批人，主管教师为第二审批人。

  

  具体课程的主讲和主管教师对应关系数据，可预先存储到数据库中。

  

  如果已提交的申请不符合申请条件，可以驳回，但驳回必须填写具体的原因，以便学生再次提交新的申请。

- __已审批申请查询功能__

  教师可查询已审批的申请，查询结果可使用分页显示，可使用多条件查询。



