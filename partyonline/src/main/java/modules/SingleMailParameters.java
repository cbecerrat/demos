package modules;

public class SingleMailParameters {
	private String receiver;
	private String subject;
	private String content;
	private MailTypes mailType;
	
	public SingleMailParameters() {
		// TODO Auto-generated constructor stub
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MailTypes getMailType() {
		return mailType;
	}

	public void setMailType(MailTypes mailType) {
		this.mailType = mailType;
	}

	@Override
	public String toString() {
		return "SingleMailParameters [receiver=" + receiver + ", subject=" + subject + ", content=" + content
				+ ", mailType=" + mailType + "]";
	}
}
