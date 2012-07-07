
/* 文件加入到上传队列中失败事件处理方法。针对每个出错的文件都会触发一次该方法 */
function fileQueueError(file, errorCode, message) {
    try {
        var imageName = "error.gif";
        var errorName = "";
        
        switch (errorCode) {
          case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
            errorName = "选择的文件数超过了最大上传文件数。";
            alert(errorName);
            return;
          case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
            imageName = "zerobyte.gif";
            break;
          case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
            imageName = "toobig.gif";
            break;
          case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
          case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
          default:
            alert(message);
            break;
        }
        addImage("images/swfupload/" + imageName);
    }
    catch (ex) {
        this.debug(ex);
    }
}
/* 当选择文件对话框关闭所有选择文件已经处理完成（加入上传队列成功或者失败）的事件处理方法 */
function fileDialogComplete(numFilesSelected, numFilesQueued) {
    try {
        if (numFilesQueued > 0) {
            this.startUpload();
        }
    }
    catch (ex) {
        this.debug(ex);
    }
}
/* 在文件往服务端上传之前触发此事件 */
function uploadStart(file) {
    this.addPostParam("name", file.name);
}
/* 上传事件处理方法 */
function uploadProgress(file, bytesLoaded) {
    try {
        var percent = Math.ceil((bytesLoaded / file.size) * 100);
        var progress = new FileProgress(file, this.customSettings.upload_target);
        progress.setProgress(percent);
        if (percent === 100) {
            progress.setStatus("上传完毕...");
            progress.toggleCancel(false, this);
        } else {
            progress.setStatus("上传中...");
            progress.toggleCancel(true, this);
        }
    }
    catch (ex) {
        this.debug(ex);
    }
}
/* 上传被终止或者没有成功完成事件处理方法 */
function uploadError(file, errorCode, message) {
    var imageName = "error.gif";
    var progress;
    try {
        switch (errorCode) {
          case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
            try {
                progress = new FileProgress(file, this.customSettings.upload_target);
                progress.setCancelled();
                progress.setStatus("Cancelled");
                progress.toggleCancel(false);
            }
            catch (ex1) {
                this.debug(ex1);
            }
            break;
          case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
            try {
                progress = new FileProgress(file, this.customSettings.upload_target);
                progress.setCancelled();
                progress.setStatus("Stopped");
                progress.toggleCancel(true);
            }
            catch (ex2) {
                this.debug(ex2);
            }
          case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
            imageName = "uploadlimit.gif";
            break;
          default:
            alert(message);
            break;
        }
        addImage("images/swfupload/" + imageName);
    }
    catch (ex3) {
        this.debug(ex3);
    }
}
/* 文件上传完成（服务端返回了200的HTTP状态）事件处理方法 */
function uploadSuccess(file, serverData) {
    try {
        var progress = new FileProgress(file, this.customSettings.upload_target);
        if (serverData.substring(0, 7) === "FILEID:") {
            addImage("thumbnail.php?id=" + serverData.substring(7));
            progress.setStatus("Thumbnail Created.");
            progress.toggleCancel(false);
        } else {
            addImage("images/swfupload/error.gif");
            progress.setStatus("Error.");
            progress.toggleCancel(false);
            alert(serverData);
        }
    }
    catch (ex) {
        this.debug(ex);
    }
}
/* 文件完成了一个上传周期（无论是成功还是失败此事件都会被触发，这也标志着一个文件的上传完成，可以进行下一个文件的上传）事件处理方法 */
function uploadComplete(file) {
    try {
        /*  I want the next upload to continue automatically so I'll call startUpload here */
        if (this.getStats().files_queued > 0) {
            this.startUpload();
        } else {
            var progress = new FileProgress(file, this.customSettings.upload_target);
            progress.setComplete();
            progress.setStatus("上传完成。");
            progress.toggleCancel(false);
        }
    }
    catch (ex) {
        this.debug(ex);
    }
}
function addImage(src) {
    var newImg = document.createElement("img");
    newImg.style.margin = "5px";
    document.getElementById("thumbnails").appendChild(newImg);
    if (newImg.filters) {
        try {
            newImg.filters.item("DXImageTransform.Microsoft.Alpha").opacity = 0;
        }
        catch (e) {
			// If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
            newImg.style.filter = "progid:DXImageTransform.Microsoft.Alpha(opacity=" + 0 + ")";
        }
    } else {
        newImg.style.opacity = 0;
    }
    newImg.onload = function () {
        fadeIn(newImg, 0);
    };
    newImg.src = src;
}
function fadeIn(element, opacity) {
    var reduceOpacityBy = 5;
    var rate = 30;	// 15 fps
    if (opacity < 100) {
        opacity += reduceOpacityBy;
        if (opacity > 100) {
            opacity = 100;
        }
        if (element.filters) {
            try {
                element.filters.item("DXImageTransform.Microsoft.Alpha").opacity = opacity;
            }
            catch (e) {
				// If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
                element.style.filter = "progid:DXImageTransform.Microsoft.Alpha(opacity=" + opacity + ")";
            }
        } else {
            element.style.opacity = opacity / 100;
        }
    }
    if (opacity < 100) {
        setTimeout(function () {
            fadeIn(element, opacity);
        }, rate);
    }
}
/* ******************************************
 *	FileProgress Object
 *	Control object for displaying file info
 * ****************************************** */
function FileProgress(file, targetID) {
    this.fileProgressID = "divFileProgress";
    this.fileProgressWrapper = document.getElementById(this.fileProgressID);
    if (!this.fileProgressWrapper) {
        this.fileProgressWrapper = document.createElement("div");
        this.fileProgressWrapper.className = "progressWrapper";
        this.fileProgressWrapper.id = this.fileProgressID;
        this.fileProgressElement = document.createElement("div");
        this.fileProgressElement.className = "progressContainer";
        var progressCancel = document.createElement("a");
        progressCancel.className = "progressCancel";
        progressCancel.href = "#";
        progressCancel.style.visibility = "hidden";
        progressCancel.appendChild(document.createTextNode(" "));
        var progressText = document.createElement("div");
        progressText.className = "progressName";
        progressText.appendChild(document.createTextNode(file.name));
        var progressBar = document.createElement("div");
        progressBar.className = "progressBarInProgress";
        var progressStatus = document.createElement("div");
        progressStatus.className = "progressBarStatus";
        progressStatus.innerHTML = "&nbsp;";
        this.fileProgressElement.appendChild(progressCancel);
        this.fileProgressElement.appendChild(progressText);
        this.fileProgressElement.appendChild(progressStatus);
        this.fileProgressElement.appendChild(progressBar);
        this.fileProgressWrapper.appendChild(this.fileProgressElement);
        document.getElementById(targetID).appendChild(this.fileProgressWrapper);
        fadeIn(this.fileProgressWrapper, 0);
    } else {
        this.fileProgressElement = this.fileProgressWrapper.firstChild;
        this.fileProgressElement.childNodes[1].firstChild.nodeValue = file.name;
    }
    this.height = this.fileProgressWrapper.offsetHeight;
}
FileProgress.prototype.setProgress = function (percentage) {
    this.fileProgressElement.className = "progressContainer green";
    this.fileProgressElement.childNodes[3].className = "progressBarInProgress";
    this.fileProgressElement.childNodes[3].style.width = percentage + "%";
};
FileProgress.prototype.setComplete = function () {
    this.fileProgressElement.className = "progressContainer blue";
    this.fileProgressElement.childNodes[3].className = "progressBarComplete";
    this.fileProgressElement.childNodes[3].style.width = "";
};
FileProgress.prototype.setError = function () {
    this.fileProgressElement.className = "progressContainer red";
    this.fileProgressElement.childNodes[3].className = "progressBarError";
    this.fileProgressElement.childNodes[3].style.width = "";
};
FileProgress.prototype.setCancelled = function () {
    this.fileProgressElement.className = "progressContainer";
    this.fileProgressElement.childNodes[3].className = "progressBarError";
    this.fileProgressElement.childNodes[3].style.width = "";
};
FileProgress.prototype.setStatus = function (status) {
    this.fileProgressElement.childNodes[2].innerHTML = status;
};
FileProgress.prototype.toggleCancel = function (show, swfuploadInstance) {
    this.fileProgressElement.childNodes[0].style.visibility = show ? "visible" : "hidden";
    if (swfuploadInstance) {
        var fileID = this.fileProgressID;
        this.fileProgressElement.childNodes[0].onclick = function () {
            swfuploadInstance.cancelUpload(fileID);
            return false;
        };
    }
};

