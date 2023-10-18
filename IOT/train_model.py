from multiprocessing import freeze_support

from ultralytics import YOLO

if __name__ == '__main__':
    freeze_support()
    # Load a model
    model = YOLO("yolov8n.pt")  # load a pretrained model (recommended for training)

    # Use the model
    model.train(data="datasets/data.yaml", epochs=85, batch=32)  # train the model